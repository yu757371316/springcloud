package com.example.feign.service;

import com.example.common.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author :  20160301301
 * @date : 2018/9/28 17:26
 */
@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {
}
