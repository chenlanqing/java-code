package com.blue.fish.se.thread.pool.schedule;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2, Executors.defaultThreadFactory());


        pool.scheduleAtFixedRate(()->{
            System.out.println(LocalDateTime.now());
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }
}
