package com.example.register;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringRegisterApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringRegisterApplication.class).web(true).run(args);
    }
}
