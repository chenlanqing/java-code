package com.blue.fish.se.thread.producer.wait;

/**
 * @author bluefish 2018/6/30
 * @version 1.0.0
 */
public class WaitAndNotifyDemo {

    private static int count = 0;

    private static final int FULL = 10;

    private static Object LOCK = new Object();

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();
        new Thread(new Producer()).start();

        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true){
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

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true){
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
                    System.out.println(Thread.currentThread().getName() + " ~~~~~消费者消费， 目前总共有:" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
