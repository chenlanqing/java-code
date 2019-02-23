package com.blue.fish.se.thread.sync;

/**
 * synchronized可重入锁粒度测试：调用类内部另外的方法
 *
 * @author bluefish 2019-02-23
 * @version 1.0.0
 */
public class SynchronizedReentrantParticle2 {

    public static void main(String[] args) {
        SynchronizedReentrantParticle2 instance = new SynchronizedReentrantParticle2();
        instance.method1();
    }


    public synchronized void method1() {
        System.out.println("method1 方法");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2 方法");

    }
}
