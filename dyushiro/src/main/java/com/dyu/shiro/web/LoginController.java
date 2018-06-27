package com.dyu.shiro.web;

/**
 * Created by yudi on 2018/3/27.
 */
public class LoginController {

    private final String a;

    public LoginController(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        new LoginController("000");
    }
}