package com.blue.fish.spring.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author bluefish 2020-03-17
 * @version 1.0.0
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition person = beanFactory.getBeanDefinition("person");
        if (Objects.equals(person.getBeanClassName(), "com.blue.fish.spring.entity.Person")) {
            MutablePropertyValues propertyValues = person.getPropertyValues();
            List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();

            for (PropertyValue propertyValue : propertyValueList) {
                if (propertyValue.getName().equals("address"))
                propertyValues.removePropertyValue(propertyValue);
            }

        }
        System.out.println(beanFactory);
    }
}
