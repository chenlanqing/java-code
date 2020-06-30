package com.blue.fish.design.pattern.creational.singleton;


import javax.annotation.concurrent.ThreadSafe;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@ThreadSafe
public class LazyThreadSafeSingleton {

    private static LazyThreadSafeSingleton lazySingleton;

    private LazyThreadSafeSingleton(){

    }

    public synchronized static LazyThreadSafeSingleton getInstance(){
        if (lazySingleton == null) {
            lazySingleton = new LazyThreadSafeSingleton();
        }
        return lazySingleton;
    }
}
