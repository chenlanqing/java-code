package com.blue.fish.se.thread.stop;

/**
 * @author bluefish 2019-09-08
 * @version 1.0.0
 */
public class StopThreadWithoutSleep {

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
                if (num % 10000 == 0) {
                    System.out.println(num + " 是10000的倍数");
                }
                num++;
            }
        };
        Thread t = new Thread(run);
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
