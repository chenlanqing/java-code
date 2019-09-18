package com.blue.fish.se.thread.base;

/**
 * 交替打印奇偶数：线程不需要判断是否为奇偶数，只需要两个线程能够交替打印即可，通过wait和notify来通信
 *
 * @author bluefish 2019-09-18
 * @version 1.0.0
 */
public class AlternatePrintOddEvenNumber2 {

    public static void main(String[] args) {
        new Thread(new OddEvenNumber()).start();
        new Thread(new OddEvenNumber()).start();
    }

    private static int count = 0;
    private static final Object lock = new Object();

    static class OddEvenNumber implements Runnable {
        int max = 100;

        @Override
        public void run() {
            while (count <= max) {
                synchronized (lock) {
                    System.out.println(count++);
                    lock.notify();

                    if (count <= max) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
