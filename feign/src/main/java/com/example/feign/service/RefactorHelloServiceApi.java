package com.example.feign.service;

import com.example.common.service.HelloServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author :  20160301301
 * @date : 2018/9/28 17:26
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloServiceApi extends HelloServiceApi {
}
