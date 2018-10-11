package com.example.feign.fallback;

import com.example.common.dto.Use;
import com.example.feign.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :  20160301301
 * @date : 2018/9/29 10:24
 */
@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public Use hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new Use("error", 0);
    }

    @Override
    public String hello(@RequestBody Use use) {
        return "error";
    }
}
