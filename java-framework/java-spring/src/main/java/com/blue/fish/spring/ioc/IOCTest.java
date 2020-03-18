package com.blue.fish.spring.ioc;

import com.blue.fish.spring.entity.Person;
import com.blue.fish.spring.extension.MySpringUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bluefish 2019-07-21
 * @version 1.0.0
 */
public class IOCTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");

        Person person = context.getBean(Person.class);

        System.out.println(person);

        System.out.println(MySpringUtils.getBean("person", Person.class));
    }
}
