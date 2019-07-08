package com.blue.fish.se.thread.pool.schedule;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class TimerTaskDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5000);
    }
}
