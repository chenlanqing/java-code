package com.blue.fish.se.thread.base;

/**
 * @author bluefish 2019-05-12
 * @version 1.0.0
 */
public class ThreadYield {

    public static void main(String[] args) throws Exception{
        YieldThread yieldThread = new YieldThread();
        Thread t1 = new Thread(yieldThread, "FirstThread");
        Thread t2 = new Thread(yieldThread, "SecondThread");

        t1.start();
        t2.start();
    }

    static class YieldThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.yield();
            }
        }
    }
}
