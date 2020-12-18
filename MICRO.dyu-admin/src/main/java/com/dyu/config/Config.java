package com.dyu.config;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author dyu
 * @date 2018/08/07
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "begin")
public class Config {
    private String one;
    private String two;



    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(3);

        for (int i = 0; i < 50; i++) {
            boolean acquire = rateLimiter.tryAcquire();
            System.out.println(acquire);
        }
    }
}
