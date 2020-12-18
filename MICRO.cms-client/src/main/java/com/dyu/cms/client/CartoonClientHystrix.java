package com.dyu.cms.client;

import org.springframework.stereotype.Component;

/**
 * @author dyu
 * @date 2018/08/03
 */
@Component
public class CartoonClientHystrix implements CartoonClient{

    @Override
    public String lists() {
        return "this server is down...";
    }
}
