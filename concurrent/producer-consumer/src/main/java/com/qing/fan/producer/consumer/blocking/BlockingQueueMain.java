package com.qing.fan.producer.consumer.blocking;

import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:23
 */
public class BlockingQueueMain {

    private static int count = 0;

    private static final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

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
                blockingQueue.put(i);
                count++;
                System.out.println(Thread.currentThread().getName() + " ~~~~~生产者生产， 目前总共有:" + count);
            }
        }
    }

    public static class Consumer implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(3000);
                blockingQueue.take();
                count--;
                System.err.println(Thread.currentThread().getName() + " ^^^^^^消费者消费， 目前总共有:" + count);
            }
        }
    }
}
