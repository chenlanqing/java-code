package com.blue.fish.se.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author bluefish 2019-06-13
 * @version 1.0.0
 */
public class GetThreadExeResult {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(5000);
            System.out.println("线程执行完成......");
            return "Hello";
        };

        FutureTask<String> future = new FutureTask<>(callable);

        Thread t = new Thread(future);
        t.start();

        String s = future.get();
        System.out.println("获取结果中....");
        System.out.println("Thread execution result:" + s);
    }
}
