package com.abucloud.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @description:
 * @author: liu kang
 */
public class AspectLog implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("personBean")) {
            System.out.println("personBean before");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("personBean")) {
            System.out.println("personBean after");
        }
        return bean;
    }
}
