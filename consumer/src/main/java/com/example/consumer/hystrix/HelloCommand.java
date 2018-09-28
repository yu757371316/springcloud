package com.example.consumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * @author :  20160301301
 * @date : 2018/9/28 10:37
 */
public class HelloCommand extends HystrixCommand<String> {

    private static final HystrixCommandKey GETTER_KEY = HystrixCommandKey.Factory.asKey("CommandKey");
    private RestTemplate restTemplate;
    private int id;

    protected HelloCommand(RestTemplate restTemplate, int id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetSetGet")).andCommandKey(GETTER_KEY));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    protected static void flushCacheKey(int id) {
        //刷新缓存根据ID清除缓存
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }

    @Override
    protected String run() throws Exception {
        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        //清除掉缓存
        HelloCommand.flushCacheKey(id);
        return result;
    }

    @Override
    protected String getCacheKey() {
        //根据ID存入缓存
        return String.valueOf(id);
    }
}
