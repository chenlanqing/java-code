package com.blue.fish.se.thread.base;

/**
 * JVM最大支持多少个线程
 *
 * @author bluefish 2019-05-20
 * @version 1.0.0
 */
public class MaxThreadInJVM {

    private static Object s = new Object();
    private static int count = 0;

    public static void main(String[] args) {
        while (true) {
            new Thread(() -> {
                synchronized (s) {
                    count++;
                    System.err.println("new thread #" + count);
                }
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }
}
