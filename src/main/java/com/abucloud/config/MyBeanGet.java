package com.abucloud.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @description:
 * @author: liu kang
 */
public class MyBeanGet implements ApplicationListener<ContextRefreshedEvent> {

    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.applicationContext= event.getApplicationContext();

        Object bean = applicationContext.getBean("&myFactoryBean");
        Object bean2 = applicationContext.getBean("myFactoryBean");
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
    }
}
