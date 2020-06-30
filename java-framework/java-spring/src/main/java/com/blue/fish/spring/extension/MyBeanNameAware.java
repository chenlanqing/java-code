package com.blue.fish.spring.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-03-18
 * @version 1.0.0
 */
@Component
public class MyBeanNameAware implements BeanNameAware, BeanFactoryAware {

    @Autowired
    private Environment environment;

    @Override
    public void setBeanName(String name) {
        System.out.println("myBeanNameWare...." + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanNameAware#setBeanFactory......" + beanFactory);
    }
}
