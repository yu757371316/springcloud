package com.example.provider.rest;

import com.example.common.dto.Use;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


/**
 * @author :  20160301301
 * @date : 2018/9/17 9:34
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        ServiceInstance instance = client.getLocalServiceInstance();

        int sleepTime = new Random().nextInt(1500);
        Thread.sleep(sleepTime);
        logger.info("hello, /host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", sleepTime:" + sleepTime);

        return "Hello World";
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name) throws InterruptedException {
        return "Hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public Use hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) throws InterruptedException {
        return new Use(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody Use use) throws InterruptedException {
        return "Hello " + use.getName() + ", " + use.getAge();
    }
}
