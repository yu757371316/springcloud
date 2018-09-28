package com.example.consumer.rest;

import com.example.consumer.service.HelloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  20160301301
 * @date : 2018/9/17 9:34
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
       return helloService.helloService(1);
    }
}
