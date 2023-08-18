package com.dyu.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author dyu 2021/4/23 14:11
 */
@Aspect
@Component
public class DiyAop {

    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doSomething() {
        System.out.println("enter aop.");
    }

    @After("pointcut()")
    public void over() {
        System.out.println("quit aop.");
    }

    
}
