package com.blue.fish.se.thread.juc.tools;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author bluefish 2018/8/7
 * @version 1.0.0
 */
@Slf4j
public class SemaphoreDemo {
    private final static int threadCount = 20;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= threadCount; i++) {
            final int count = i;
            executorService.execute(() -> {
                try{
                    // 写法1: 获取许可,执行方法,释放许可
//                    semaphore.acquire();
//                    test(count);
//                    semaphore.release();

                    // 写法2:尝试获取许可,获取成功则执行方法;如果没有获取成功,则不丢弃;
                    // 尝试获取可以设置超时时间:tryAcquire(long timeout, TimeUnit unit)
                    if (semaphore.tryAcquire()){
                        test(count);
                        semaphore.release();
                    }
                }catch (Exception e){
                    log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
    }
    private static void test(int count) throws Exception {
        Thread.sleep(1000);
        log.info("{}, {}", count, Thread.currentThread().getName());
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
