package com.blue.fish.se.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2019-06-13
 * @version 1.0.0
 */
public class ThreadPoolRejectPolicy {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
                10000, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Thread t = new Thread(r);
                    t.setName("Test-Reject-Policy");
                    return t;
                },
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            final int count = i;
            pool.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "-" + count);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
    }
}
