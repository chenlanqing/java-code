package com.blue.fish.spring.extension;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-03-18
 * @version 1.0.0
 */
@Component
public class MyBeanNameAware implements BeanNameAware {

    @Autowired
    private Environment environment;

    @Override
    public void setBeanName(String name) {
        System.out.println("myBeanNameWare...." + name);
    }
}
