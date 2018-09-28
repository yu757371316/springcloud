package com.example.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author :  20160301301
 * @date : 2018/9/17 9:34
 */
@Service
public class HelloService {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            })
    //同步执行的实现
    public String helloService(int id) {
        String result =  restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        if (result == null) {
            throw new RuntimeException("返回结果为空");
        }
        return result;
    }

    @CacheResult
    @HystrixCommand(fallbackMethod = "helloFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            })
    //同步执行的实现
    public String helloServiceSync(@CacheKey("id") int id) {
        String result =  restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        if (result == null) {
            throw new RuntimeException("返回结果为空");
        }
        return result;
    }

    //@CacheRemove(commandKey = "helloService")
    @HystrixCommand(fallbackMethod = "helloFallback")
    //异步获取结果
    public AsyncResult<String> helloServiceAsync(@CacheKey("id") int id) {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                String result =   restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
                if (result == null) {
                    throw new RuntimeException("返回结果为空");
                }
                return result;
            }
        };
    }

    //实现异常的捕获
    public String helloFallback(int id, Throwable e) {
        if (e!= null) {
            return e.getMessage();
        }
        return "error";
    }
}
