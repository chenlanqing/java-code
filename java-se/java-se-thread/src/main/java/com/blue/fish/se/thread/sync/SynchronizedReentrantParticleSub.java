package com.blue.fish.se.thread.sync;

/**
 * synchronized可重入锁粒度测试：子类调用父类的方法
 *
 * @author bluefish 2019-02-23
 * @version 1.0.0
 */
public class SynchronizedReentrantParticleSub extends SynchronizedReentrantParticle3{

    public static void main(String[] args) {
        SynchronizedReentrantParticleSub instance = new SynchronizedReentrantParticleSub();
        instance.doSomething();
    }


    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }
    
}
