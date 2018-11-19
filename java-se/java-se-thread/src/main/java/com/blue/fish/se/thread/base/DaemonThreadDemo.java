package com.blue.fish.se.thread.base;

import java.util.Scanner;

/**
 * 守护线程示例：<br>
 * 当线程中只剩下守护线程时JVM就会退出，反之还有任意一个用户线程在，JVM都不会退出
 *
 * @author bluefish 2018/8/16
 * @version 1.0.0
 */
public class DaemonThreadDemo implements Runnable {

    @Override
    public void run() {
        while (true) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("守护线程："+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new DaemonThreadDemo());
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("is Daemon:" + daemonThread.isDaemon());

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("JVM exit");
            }
        });
    }
}
