package com.blue.fish.design.pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不使用synchronized和Lock实现单例模式
 *
 * @author bluefish 2019-02-27
 * @version 1.0.0
 */
public class CASSingleton {
    private static AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();
    private CASSingleton(){}
    public static CASSingleton getInstance() {
        for (;;){
            CASSingleton instance = INSTANCE.get();
            if (instance != null) {
                return instance;
            }
            instance = new CASSingleton();
            if (INSTANCE.compareAndSet(null, instance)) {
                return instance;
            }
        }
    }
}
