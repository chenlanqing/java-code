package com.blue.fish.se.thread.juc.tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bluefish 2018/8/7
 * @version 1.0.0
 */
@Slf4j
public class CountdownLatchDemo {
    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= threadCount; i++) {
            final int count = i;
            exec.execute(() -> {
                try {
                    test(count);
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 等待线程池中所有线程执行完毕后,main方法线程才继续执行
        countDownLatch.await();
        // 可以设置等待时长,即等待多少时间后执行main方法线程
//        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("~~~~~~~~main method finish {}", Thread.currentThread().getName());
        exec.shutdown();
    }

    private static void test(int count) throws Exception {
        Thread.sleep(100);
        log.info("{}, {}", count, Thread.currentThread().getName());
    }
}
