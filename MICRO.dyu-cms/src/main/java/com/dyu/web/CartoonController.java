package com.dyu.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyu
 * @date 2018/08/03
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CartoonController {

    @GetMapping("/lists")
    public String lists() {
        log.info("-----> enter...");
        return "hello worlds";
    }
}
