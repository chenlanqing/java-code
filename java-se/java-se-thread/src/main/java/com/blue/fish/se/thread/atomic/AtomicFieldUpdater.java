package com.blue.fish.se.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author bluefish 2019-12-31
 * @version 1.0.0
 */
public class AtomicFieldUpdater implements Runnable {

    static Student tom;
    static Student peter;

    private static AtomicIntegerFieldUpdater<Student> updater
            = AtomicIntegerFieldUpdater.newUpdater(Student.class, "score");

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            peter.score ++;
            updater.getAndIncrement(tom);
        }
    }

    static class Student {
        int score;
    }

    public static void main(String[] args) throws InterruptedException {
        peter = new Student();
        tom = new Student();

        AtomicFieldUpdater r = new AtomicFieldUpdater();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(peter.score);
        System.out.println(tom.score);
    }
}
