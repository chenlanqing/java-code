package com.blue.fish.design.pattern.creational.singleton;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class StaticInnerClassSingleton {

    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return StaticInnerClassSingletonHolder.INSTANCE;
    }
}