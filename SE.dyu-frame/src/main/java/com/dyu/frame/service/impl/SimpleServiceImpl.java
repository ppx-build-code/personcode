package com.dyu.frame.service.impl;

import com.dyu.frame.service.SimpleService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;

/**
 * @author dyu 2019.02.26
 */
@Service
public class SimpleServiceImpl implements SimpleService, ApplicationContextAware,
        ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("exec bean classloader, name is " + classLoader.getClass().getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("current bean factory name is " + beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("current bean name is " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("current high bean factory name is " + applicationContext.getClass().getName());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("current event publisher is " + applicationEventPublisher.getClass().getName());
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("current app environment param is " + environment.toString());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("exec resource loader, name is " + resourceLoader.getClass().getName());
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("annotation meta data is " + annotationMetadata.getClassName());
    }
}
