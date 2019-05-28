package com.blue.fish.se.thread.pool;

import java.util.concurrent.*;

/**
 * 重写ThreadPoolExecutor.afterExecute方法，处理传递到afterExecute方法中的异常
 *
 * @author bluefish 2019-05-25
 * @version 1.0.0
 */
public class PoolExceptionHandlerAfterExecute {

    public static void main(String[] args) {

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);

        CustomPoolExecutor poolExecutor =
                new CustomPoolExecutor(5, 10, 60, TimeUnit.SECONDS, workQueue);

        Future<Integer> future = poolExecutor.submit(() -> {
            System.out.println(1 / 0);
            return 0;
        });

        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);

                thread.setUncaughtExceptionHandler(new RewriteUncatchtExceptionHandler());

                return thread;
            }
        };


    }

    private static class CustomPoolExecutor extends ThreadPoolExecutor {

        public CustomPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            t.printStackTrace();
        }
    }
}
