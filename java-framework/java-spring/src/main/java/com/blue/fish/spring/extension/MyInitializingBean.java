package com.blue.fish.spring.extension;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-03-18
 * @version 1.0.0
 */
@Component
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean.........");
    }
}
