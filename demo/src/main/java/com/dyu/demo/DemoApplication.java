package com.dyu.demo;

import com.dyu.demo.test.A;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private A a;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
