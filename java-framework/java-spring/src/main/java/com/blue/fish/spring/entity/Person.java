package com.blue.fish.spring.entity;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author bluefish 2019-07-21
 * @version 1.0.0
 */
@Data
public class Person implements InitializingBean {

    private String name;

    private Integer age;

    private String address;

    private String gender;


    public void init(){
        System.out.println("Person ---> 初始化。。。。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person --》  afterPropertiesSet");
    }
}
