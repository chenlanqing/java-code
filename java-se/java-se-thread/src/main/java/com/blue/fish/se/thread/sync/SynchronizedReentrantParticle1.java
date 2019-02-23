package com.blue.fish.se.thread.sync;

/**
 * synchronized可重入锁粒度测试：递归调用本方法
 *
 * @author bluefish 2019-02-23
 * @version 1.0.0
 */
public class SynchronizedReentrantParticle1 {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedReentrantParticle1 instance = new SynchronizedReentrantParticle1();
        instance.method1();
    }


    public synchronized void method1() {
        System.out.println("这是Method1， a=" + a);
        if (a == 0) {
            a++;
            method1();
        }
    }
}
