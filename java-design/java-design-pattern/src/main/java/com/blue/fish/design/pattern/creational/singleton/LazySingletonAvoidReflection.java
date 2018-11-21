package com.blue.fish.design.pattern.creational.singleton;

import com.blue.fish.common.annotation.NonThreadSafe;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@NonThreadSafe
public class LazySingletonAvoidReflection {

    private static LazySingletonAvoidReflection lazySingleton;

    private LazySingletonAvoidReflection(){
        if (lazySingleton != null){
            throw new RuntimeException("单例不能通过反射构建实例");
        }
    }

    public static LazySingletonAvoidReflection getInstance(){
        if (lazySingleton == null) {
            lazySingleton = new LazySingletonAvoidReflection();
        }
        return lazySingleton;
    }
}
