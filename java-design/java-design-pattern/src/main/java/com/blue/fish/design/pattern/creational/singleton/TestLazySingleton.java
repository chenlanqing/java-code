package com.blue.fish.design.pattern.creational.singleton;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class TestLazySingleton {

    public static void main(String[] args) {
        Runnable runnable = new T();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        System.out.println("单例获取");
    }
}