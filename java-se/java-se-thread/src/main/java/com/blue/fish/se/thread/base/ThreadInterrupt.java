package com.blue.fish.se.thread.base;

/**
 * @author bluefish 2020-03-01
 * @version 1.0.0
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("sub thread " + Thread.interrupted());
            System.out.println("sub thread " + Thread.interrupted());
            for (; ; ) {

            }
        });

        // 启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();

//        Thread.currentThread().interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + thread.isInterrupted());// true
        //获取中断标志并重置
        System.out.println("isInterrupted: " + Thread.interrupted());// false
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());// false
        //获取中断标志
        System.out.println("isInterrupted: " + thread.isInterrupted());// true
        thread.join();
        System.out.println("Main thread is over.");
    }
}
