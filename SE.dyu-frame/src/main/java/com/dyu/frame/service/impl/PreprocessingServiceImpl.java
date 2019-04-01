package com.dyu.frame.service.impl;

import com.dyu.frame.service.PreprocessingService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @author dyu 2019.02.26
 */
@Service
public class PreprocessingServiceImpl implements PreprocessingService, BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("bean name => " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        return o;
    }
}
