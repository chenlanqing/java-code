package com.qing.fan.producer.consumer.semaphore;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:33
 */
public class SemaphoreMain {

    private static int count = 0;

    private static final Semaphore empty = new Semaphore(10);

    private static final Semaphore full = new Semaphore(0);

    private static final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(), "生产者" + i).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(), "消费者" + i).start();
        }
    }

    private static class Producer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(3000);
                try {
                    empty.acquire();
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() + " ~~~~~生产者生产， 目前总共有:" + count);
                } finally {
                    mutex.release();
                    full.release();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(3000);
                try {
                    full.acquire();
                    mutex.acquire();
                    count--;
                    System.err.println(Thread.currentThread().getName() + " ~~~~~消费者消费， 目前总共有:" + count);
                } finally {
                    mutex.release();
                    empty.release();
                }
            }
        }
    }
}
