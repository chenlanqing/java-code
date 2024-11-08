package com.qing.fan.producer.consumer.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:09
 */
public class ReentrantLockMain {
    private static int count = 0;

    private static final int FULL = 10;

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final Condition notFull = LOCK.newCondition();

    private static final Condition notEmpty = LOCK.newCondition();


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(), "生产者" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(), "消费者" + i).start();
        }
    }

    private static class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOCK.lock();
                try {
                    while (count == FULL) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "（生产）了一个产品，当前产品数量：" + count);
                    notEmpty.signal();
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOCK.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.err.println(Thread.currentThread().getName() + "【消费】了一个产品，当前产品数量：" + count);
                    notFull.signal();
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }
}
