package com.blue.fish.se.thread.base;

/**
 * 交替打印奇偶数：使用两个Runnable实现类来操作；
 *
 * @author bluefish 2019-09-18
 * @version 1.0.0
 */
public class AlternatePrintOddEvenNumber {

    public static void main(String[] args) throws InterruptedException {
        Thread odd = new Thread(new OddNumberThread());
        Thread even = new Thread(new EvenNumberThread());

        even.start();
        Thread.sleep(100);
        odd.start();

    }

    private static int max_num = 100;
    private final static Object lock = new Object();

    static class OddNumberThread implements Runnable {
        @Override
        public void run() {
            int i = 1;
            while (i <= max_num) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("奇数线程：" + i);
                        lock.notify();
                    }

                }
                i ++;
            }
        }
    }
    static class EvenNumberThread implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i <= max_num) {
                synchronized (lock) {
                    if (i % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("偶数线程：" + i);
                        lock.notify();
                    }

                }
                i ++;
            }
        }
    }
}
