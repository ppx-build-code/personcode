package com.dyu.demo.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author dyu
 * @date 2018/05/12
 **/
@Configuration
public class Config {

    @Bean
    @Qualifier("test1")
    @Primary
    public A getAInfo(){
        return new A("ab", "ba");
    }

    @Bean
    @Qualifier("test2")
    public A getInfo(){
        return new A("aa", "bb");
    }

}
