package com.blue.fish.source.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

@Order(2)
public class SecondInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        Map<String, Object> map = new HashMap<>(1);
        map.put("second", "second");
        MapPropertySource source = new MapPropertySource("secondInitializer", map);
        propertySources.addLast(source);
        System.out.println("Run Second Initializer...");
    }
}