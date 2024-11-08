package com.qing.fan.producer.consumer.wait;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:01
 */
public class WaitNotifyMain {

    private static int count = 0;
    private static final int FULL = 10;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(), "生产者" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(), "消费者" + i).start();
        }

    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + " ~~~~~生产者生产， 目前总共有:" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.err.println(Thread.currentThread().getName() + " ~~~~~消费者消费， 目前总共有:" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
