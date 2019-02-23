package com.blue.fish.se.thread.sync;

/**
 * synchronized可重入锁粒度测试：子类调用父类的方法
 *
 * @author bluefish 2019-02-23
 * @version 1.0.0
 */
public class SynchronizedReentrantParticle3 {

    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }
}
