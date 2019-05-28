package com.blue.fish.se.thread.pool;

import java.util.concurrent.*;

public class FutureCancelTaskTest {

//    public static void main(String[] args) throws Exception {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//
//        SimpleTask task = new SimpleTask(3_000); // task 需要运行 3 秒
//        Future<Double> future = threadPool.submit(task);
//        threadPool.shutdown(); // 发送关闭线程池的指令
//
//        double time = future.get();
//        System.out.format("任务运行时间: %.3f s\n", time);
//
//    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        SimpleTask task = new SimpleTask(3_000); // task 需要运行 3 秒
        Future<Double> future = threadPool.submit(task);
        threadPool.shutdown(); // 发送关闭线程池的指令

        cancelTask(future, 2_000); // 在 2 秒之后取消该任务

        try {
            double time = future.get();
            System.out.format("任务运行时间: %.3f s\n", time);
        } catch (CancellationException ex) {
            System.err.println("任务被取消");
        } catch (InterruptedException ex) {
            System.err.println("当前线程被中断");
        } catch (ExecutionException ex) {
            System.err.println("任务执行出错");
        }

    }

    private static void cancelTask(final Future<?> future, final int delay) {
        Runnable cancellation = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                    future.cancel(true); // 取消与 future 关联的正在运行的任务
                } catch (InterruptedException ex) {
                    ex.printStackTrace(System.err);
                }
            }
        };

        new Thread(cancellation).start();
    }

    private static final class SimpleTask implements Callable<Double> {

        private final int sleepTime; // ms

        public SimpleTask(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public Double call() throws Exception {
            double begin = System.nanoTime();

            Thread.sleep(sleepTime);

            double end = System.nanoTime();
            double time = (end - begin) / 1E9;

            return time; // 返回任务运行的时间，以 秒 计
        }

    }
}