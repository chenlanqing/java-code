package com.blue.fish.design.pattern.creational.singleton;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author QingFan 2020-06-29
 * @version 1.0.0
 */
public class CASStampSingleton {

    private static AtomicStampedReference<CASStampSingleton> reference = new AtomicStampedReference<>(null, 1);

    private CASStampSingleton() {
    }

    public static CASStampSingleton getInstance() {
        while (true) {
            CASStampSingleton instance = CASStampSingleton.reference.getReference();
            if (instance != null) {
                return instance;
            }
            System.out.println("初始化: " + Thread.currentThread().getName());
            instance = new CASStampSingleton();

            if (reference.compareAndSet(null, instance, 1, 2)) {
                System.out.println("设置成功: " + Thread.currentThread().getName());
                return instance;
            }
        }
    }
}
