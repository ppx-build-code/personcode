package com.dyu.config;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyu
 * @date 2018/08/01
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String get() {
        return "hello world";
    }
}
