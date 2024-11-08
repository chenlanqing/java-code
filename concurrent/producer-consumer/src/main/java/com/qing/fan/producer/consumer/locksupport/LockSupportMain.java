package com.qing.fan.producer.consumer.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 22:09
 */
public class LockSupportMain {

    private static volatile boolean isProduced = false; // 表示是否生产了数据

    private static Thread producerThread;

    private static Thread consumerThread;

    public static void main(String[] args) {
        producerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                while (isProduced) {
                    LockSupport.park(); // 生产者等待消费者消费完
                }
                System.out.println("Produced: " + i);
                isProduced = true;
                LockSupport.unpark(consumerThread); // 唤醒消费者
            }
        });

        consumerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                while (!isProduced) {
                    LockSupport.park(); // 消费者等待生产者生产完
                }
                System.out.println("Consumed: " + i);
                isProduced = false;
                LockSupport.unpark(producerThread); // 唤醒生产者
            }
        });

        // 启动线程
        producerThread.start();
        consumerThread.start();

        // 预先唤醒生产者线程开始生产
        LockSupport.unpark(producerThread);
    }
}
