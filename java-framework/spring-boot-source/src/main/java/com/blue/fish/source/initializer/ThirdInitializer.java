package com.blue.fish.source.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

@Order(3)
public class ThirdInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        Map<String, Object> map = new HashMap<>(1);
        map.put("third", "third");
        MapPropertySource source = new MapPropertySource("thirdInitializer", map);
        propertySources.addLast(source);
        System.out.println("Run Third Initializer...");
    }
}