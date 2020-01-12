package com.blue.fish.source.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bluefish 2020-01-12
 * @version 1.0.0
 */
@Service
public class HelloService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String hello() {
        Map<String, Object> map = new HashMap<>(3);
        map.put("first", applicationContext.getEnvironment().getProperty("first"));
        map.put("second", applicationContext.getEnvironment().getProperty("second"));
        map.put("third", applicationContext.getEnvironment().getProperty("third"));
        return JSON.toJSONString(map);
    }
}
