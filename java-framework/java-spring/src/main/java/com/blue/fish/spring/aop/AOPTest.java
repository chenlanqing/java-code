package com.blue.fish.spring.aop;

import com.blue.fish.spring.aop.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author bluefish 2019-07-21
 * @version 1.0.0
 */
public class AOPTest {

    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring/spring-aop.xml"));

        UserService service = bf.getBean(UserService.class);
        service.hello();

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
//        UserService service = context.getBean(UserService.class);
//        service.hello();
    }
}
