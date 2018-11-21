package com.blue.fish.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class LazySingletonComplete implements Serializable{
    private static final long serialVersionUID = -4697231243331288541L;
    private static LazySingletonComplete instance;
    private LazySingletonComplete(){
        if (instance != null){
            throw new RuntimeException("单例不能通过反射构建实例");
        }
    }

    public static LazySingletonComplete getInstance(){
        synchronized (LazySingletonComplete.class) {
            if (instance == null){
                instance = new LazySingletonComplete();
            }
            return instance;
        }
    }

    private Object readResolve(){
        return instance;
    }
}