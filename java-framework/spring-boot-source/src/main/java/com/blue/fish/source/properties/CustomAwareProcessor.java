package com.blue.fish.source.properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author bluefish 2020-01-15
 * @version 1.0.0
 */
@Component
public class CustomAwareProcessor implements BeanPostProcessor {
    private final ConfigurableApplicationContext configurableApplicationContext;

    public CustomAwareProcessor(ConfigurableApplicationContext configurableApplicationContext) {
        this.configurableApplicationContext = configurableApplicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Aware) {
            if (bean instanceof CustomAware) {
                ((CustomAware)bean).setCustomFlag((CustomFlag) configurableApplicationContext.getBean("customFlag"));
            }
        }
        return bean;
    }
}
