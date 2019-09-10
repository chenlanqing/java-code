package com.blue.fish.spring.util;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bluefish 2019-07-24
 * @version 1.0.0
 */
public class SpringRegisterBeanUtil {

    private static ApplicationContext context;

    private static ConfigurableApplicationContext configContext;

    private static BeanDefinitionRegistry registry;

    static {
        context = new ClassPathXmlApplicationContext("spring/bean-register.xml");
        configContext = (ConfigurableApplicationContext) context;
        registry = (DefaultListableBeanFactory) configContext.getBeanFactory();
    }

    public static <T> void registerBean(String beanId, T t) {
        String className = t.getClass().getName();

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(t.getClass());

        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

        registry.registerBeanDefinition(beanId, beanDefinition);
    }

    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }
}
