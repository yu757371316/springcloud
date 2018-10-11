package com.example.provider.rest;

import com.example.common.dto.Use;
import com.example.common.service.HelloServiceApi;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  20160301301
 * @date : 2018/9/28 17:26
 */
@RestController
public class RefactorHelloControllerApi implements HelloServiceApi {

    @Override
    public String hello(@RequestParam("name") String name)  {
        return "Hello " + name;
    }

    @Override
    public Use hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new Use(name, age);
    }

    @Override
    public String hello(@RequestBody Use use) {
        return "Hello " + use.getName() + ", " + use.getAge();
    }
}
