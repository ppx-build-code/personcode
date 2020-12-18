package com.dyu.cms.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "micro-dyu-cms", fallback = CartoonClientHystrix.class)
public interface CartoonClient {

    @GetMapping("/lists")
    String lists();
}
