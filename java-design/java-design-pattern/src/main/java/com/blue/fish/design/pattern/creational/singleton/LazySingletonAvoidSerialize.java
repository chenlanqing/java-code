package com.blue.fish.design.pattern.creational.singleton;

import com.blue.fish.common.annotation.NonThreadSafe;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class LazySingletonAvoidSerialize {

    private static LazySingletonAvoidSerialize lazySingleton;

    private LazySingletonAvoidSerialize(){
    }

    public static LazySingletonAvoidSerialize getInstance(){
        if (lazySingleton == null) {
            lazySingleton = new LazySingletonAvoidSerialize();
        }
        return lazySingleton;
    }

    private Object readResolve(){
        return lazySingleton;
    }
}
