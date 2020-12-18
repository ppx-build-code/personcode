package com.dyu.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CmsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsClientApplication.class, args);
    }
}
