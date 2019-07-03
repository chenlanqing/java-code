package com.blue.fish.netty;

import io.netty.util.HashedWheelTimer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2019-03-16
 * @version 1.0.0
 */
public class HashTimerWheelTest1 {

    public static void main(String[] args) throws InterruptedException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
//        System.out.println("start:" + LocalDateTime.now().format(formatter));
//        hashedWheelTimer.newTimeout(timeout -> {
//            System.out.println("task :" + LocalDateTime.now().format(formatter));
//        }, 3, TimeUnit.SECONDS);
//        Thread.sleep(5000);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        System.out.println("start:" + LocalDateTime.now().format(formatter));
        hashedWheelTimer.newTimeout(timeout -> {
            Thread.sleep(3000);
            System.out.println("task1:" + LocalDateTime.now().format(formatter));
        }, 3, TimeUnit.SECONDS);
        hashedWheelTimer.newTimeout(timeout -> System.out.println("task2:" + LocalDateTime.now().format(
                formatter)), 4, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }
}
