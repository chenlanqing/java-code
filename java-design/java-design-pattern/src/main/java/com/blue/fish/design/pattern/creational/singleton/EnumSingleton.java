package com.blue.fish.design.pattern.creational.singleton;

import java.lang.reflect.Constructor;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public enum  EnumSingleton {
    INSTANCE;

    public static void main(String[] args) throws Exception{
        Constructor[] array = EnumSingleton.INSTANCE.getClass().getDeclaredConstructors();
        for (Constructor constructor : array) {
            constructor.setAccessible(true);
            constructor.newInstance(null);
        }
    }
}