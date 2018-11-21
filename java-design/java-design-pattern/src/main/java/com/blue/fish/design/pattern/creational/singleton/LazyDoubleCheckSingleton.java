package com.blue.fish.design.pattern.creational.singleton;

import com.blue.fish.common.annotation.NonThreadSafe;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@NonThreadSafe
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazySingleton;

    private LazyDoubleCheckSingleton(){
    }

    public static LazyDoubleCheckSingleton getInstance(){
        if (lazySingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}