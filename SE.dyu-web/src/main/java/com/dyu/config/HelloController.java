package com.dyu.config;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyu
 * @date 2018/08/01
 */
@Controller
public class HelloController {
    @GetMapping(value = "/hello")
    public String get(@RequestParam(required = false, defaultValue = "one") String code) {
        if (code.equals("one")) {
            return "one_test";
        } else {
            return "two_test";
        }
    }

    @GetMapping(value = "/test")
    public String opt() {
        return "redirect:/hello?code=two";
    }
}
