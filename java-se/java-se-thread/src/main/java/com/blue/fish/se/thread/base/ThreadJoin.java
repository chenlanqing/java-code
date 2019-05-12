package com.blue.fish.se.thread.base;

/**
 * @author bluefish 2019-05-12
 * @version 1.0.0
 */
public class ThreadJoin {

    public static void main(String[] args) throws Exception{
        JoinThread yield = new JoinThread();

        Thread t1 = new Thread(yield, "t1");
        Thread t2 = new Thread(yield, "t2");
        Thread t3 = new Thread(yield, "t3");

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }

    static class JoinThread implements Runnable {

        @Override
        public void run() {
            System.out.println("current thread name:" + Thread.currentThread().getName());
        }
    }
}
