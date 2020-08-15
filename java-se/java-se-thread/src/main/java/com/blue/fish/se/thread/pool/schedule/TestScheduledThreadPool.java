package com.blue.fish.se.thread.pool.schedule;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(2, Executors.defaultThreadFactory());
        pool.scheduleAtFixedRate(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleAtFixedRate: " + LocalDateTime.now());
        }, 1, 5000, TimeUnit.MILLISECONDS);

        pool.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("scheduleWithFixedDelay: " + LocalDateTime.now());
        }, 1, 5000, TimeUnit.MILLISECONDS);
    }
}
