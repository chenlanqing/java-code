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

            // 如果singleton不为空，就返回singleton
            if (instance != null) {
                return instance;
            }
            System.out.println("初始化: " + Thread.currentThread().getName());
            instance = new CASSingleton();
            // CAS操作，预期值是NULL，新值是singleton
            // 如果成功，返回singleton
            // 如果失败，进入第二次循环，singletonAtomicReference.get()就不会为空了
            if (INSTANCE.compareAndSet(null, instance)) {
                System.out.println("设置成功: " + Thread.currentThread().getName());
                return instance;
            }
        }
    }
}
