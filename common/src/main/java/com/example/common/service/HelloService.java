package com.example.common.service;

import com.example.common.dto.Use;
import org.springframework.web.bind.annotation.*;

/**
 * @author :  20160301301
 * @date : 2018/9/28 17:23
 */
@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    Use hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody Use use);
}
