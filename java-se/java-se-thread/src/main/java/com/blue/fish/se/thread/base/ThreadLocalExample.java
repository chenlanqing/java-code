package com.blue.fish.se.thread.base;

import java.text.SimpleDateFormat;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private static ThreadLocal<SimpleDateFormat> threadLocal1 = ThreadLocal.withInitial(() -> new SimpleDateFormat(""));
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws Exception {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}