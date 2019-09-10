package com.blue.fish.se.thread.stop;

/**
 * @author bluefish 2019-09-08
 * @version 1.0.0
 */
public class StopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            int num = 0;
            try {
                while (num <= 300 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + " 是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(run);
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
}
