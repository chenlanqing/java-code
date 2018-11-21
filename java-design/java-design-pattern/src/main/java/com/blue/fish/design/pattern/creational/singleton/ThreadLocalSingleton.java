package com.blue.fish.design.pattern.creational.singleton;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class ThreadLocalSingleton {

    private static ThreadLocal<ThreadLocalSingleton> instance = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return instance.get();
    }
}
