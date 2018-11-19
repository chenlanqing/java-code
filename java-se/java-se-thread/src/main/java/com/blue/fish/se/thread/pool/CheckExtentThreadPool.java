package com.blue.fish.se.thread.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2018/11/4
 * @version 1.0.0
 */
public class CheckExtentThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ExtentThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        executor.execute(new CheckThread(5));
        executor.execute(new CheckThread(4));
        executor.execute(new CheckThread(3));
        executor.execute(new CheckThread(2));
        executor.execute(new CheckThread(1));
        executor.shutdown();
    }
}

class CheckThread implements Runnable {

    private int sleep;

    public CheckThread(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");

        try {
            TimeUnit.SECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
