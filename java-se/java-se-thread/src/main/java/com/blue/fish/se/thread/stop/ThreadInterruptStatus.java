package com.blue.fish.se.thread.stop;

/**
 * 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
 *
 * @author bluefish 2019-09-08
 * @version 1.0.0
 */
public class ThreadInterruptStatus {

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(() -> {
            for (;;){

            }
        });

        // 启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + thread.isInterrupted());// true
        //获取中断标志并重置
        System.out.println("isInterrupted: " + thread.interrupted());// false
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());// false
        //获取中断标志
        System.out.println("isInterrupted: " + thread.isInterrupted());// true
        thread.join();
        System.out.println("Main thread is over.");
    }
}
