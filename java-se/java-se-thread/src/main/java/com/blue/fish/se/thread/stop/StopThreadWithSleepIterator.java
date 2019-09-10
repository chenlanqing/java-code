package com.blue.fish.se.thread.stop;

/**
 * @author bluefish 2019-09-08
 * @version 1.0.0
 */
public class StopThreadWithSleepIterator {

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    System.out.println(num + " 是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        };
        Thread t = new Thread(run);
        t.start();
        Thread.sleep(5000);
        t.interrupt();
    }
}
