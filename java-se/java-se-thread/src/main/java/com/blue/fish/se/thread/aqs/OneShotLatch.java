package com.blue.fish.se.thread.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 类似于 CountDownLatch，只不过这里只有一个固定的 Latch，
 *
 * @author bluefish 2020-02-02
 * @version 1.0.0
 */
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void await() {
        sync.tryAcquireShared(0);
    }

    public void signal() {
        sync.tryReleaseShared(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 8294860502621311646L;

        @Override
        protected int tryAcquireShared(int arg) {
            return getState() == 1 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneShotLatch oneShotLatch = new OneShotLatch();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"尝试获取latch，获取失败那就等待");
                    oneShotLatch.await();
                    System.out.println("开闸放行"+Thread.currentThread().getName()+"继续运行");
                }
            }).start();
        }
        Thread.sleep(5000);
        oneShotLatch.signal();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"尝试获取latch，获取失败那就等待");
                oneShotLatch.await();
                System.out.println("开闸放行"+Thread.currentThread().getName()+"继续运行");
            }
        }).start();
    }
}
