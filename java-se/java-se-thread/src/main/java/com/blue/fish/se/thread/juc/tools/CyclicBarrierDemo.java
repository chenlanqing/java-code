package com.blue.fish.se.thread.juc.tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bluefish 2018/8/7
 * @version 1.0.0
 */
@Slf4j
public class CyclicBarrierDemo {
//    static CyclicBarrier barrier = new CyclicBarrier(5);
    // 到达屏障后执行某个回调
    static CyclicBarrier barrier = new CyclicBarrier(5, ()->{
        log.info("sdasdasdasdasdas");
    });
    public static void main(String[] args)throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int count = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(count);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
    }
    private static void race(int count) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready", count);
        barrier.await();
        log.info("{} continue",count);
    }
}
