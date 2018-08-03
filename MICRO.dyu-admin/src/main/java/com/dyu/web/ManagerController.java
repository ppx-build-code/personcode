package com.dyu.web;

import com.dyu.cms.client.CartoonClient;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dyu
 * @date 2018/08/03
 */
@RestController
@RequiredArgsConstructor
public class ManagerController {

    @NonNull
    private CartoonClient cartoonClient;

    @GetMapping("/lists")
    public String lists() {
        return cartoonClient.lists();
    }

}
