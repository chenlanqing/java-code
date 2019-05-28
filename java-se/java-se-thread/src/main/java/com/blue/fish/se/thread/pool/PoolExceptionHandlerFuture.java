package com.blue.fish.se.thread.pool;

import java.util.concurrent.*;

/**
 * 使用Future接收返回的异常信息
 *
 * @author bluefish 2019-05-25
 * @version 1.0.0
 */
public class PoolExceptionHandlerFuture {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Future<Integer> future = pool.submit(() -> {
            System.out.println(1 / 0);
            return 0;
        });

        try {
            Integer integer = future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("线程异常");
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
