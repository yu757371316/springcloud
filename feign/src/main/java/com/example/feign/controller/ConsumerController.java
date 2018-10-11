package com.example.feign.controller;

import com.example.common.dto.Use;
import com.example.feign.service.HelloService;
import com.example.feign.service.RefactorHelloServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  20160301301
 * @date : 2018/9/28 16:13
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloServiceApi refactorHelloService;

    @RequestMapping(method = RequestMethod.GET, path = "/feign-consumer")
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/feign-consumer2")
    public String helloConsumer2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(helloService.hello()).append(" \n");
        stringBuilder.append(helloService.hello("yzc")).append(" \n");
        stringBuilder.append(helloService.hello("yzc", 30)).append(" \n");
        stringBuilder.append(helloService.hello(new Use("yzc", 30))).append(" \n");
        return stringBuilder.toString();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/feign-consumer3")
    public String helloConsumer3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(refactorHelloService.hello("yzc")).append(" \n");
        stringBuilder.append(refactorHelloService.hello("yzc", 30)).append(" \n");
        stringBuilder.append(refactorHelloService.hello(new Use("yzc", 30))).append(" \n");
        return stringBuilder.toString();
    }
}
