package com.blue.fish.se.thread.pool;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        long num = 1000000033L;
        PrimerTask task = new PrimerTask(num);
        Future<Boolean> future = threadPool.submit(task);
        threadPool.shutdown(); // 发送关闭线程池的指令

        cancelTask(future, 2_000); // 在 2 秒之后取消该任务



        try {
            boolean result = future.get();
            System.out.format("%d 是否为素数？ %b\n", num, result);
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

    private static final class PrimerTask implements Callable<Boolean> {

        private final long num;

        public PrimerTask(long num) {
            this.num = num;
        }

        @Override
        public Boolean call() throws Exception {
            // i < num 让任务有足够的运行时间
            for (long i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }

    }

}