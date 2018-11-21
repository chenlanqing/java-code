package com.blue.fish.design.pattern.creational.singleton;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class ContainerSingleton {

    private static Map<String, Object> singleMap = new HashMap<>();

    private ContainerSingleton(){

    }

    public static void putInstance(String key, Object instance) {
        if (StringUtils.isNotBlank(key) && instance != null) {
            if (!singleMap.containsKey(key)){
                singleMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singleMap.get(key);
    }
}
