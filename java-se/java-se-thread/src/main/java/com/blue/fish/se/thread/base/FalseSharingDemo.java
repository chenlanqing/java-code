package com.blue.fish.se.thread.base;


/**
 * 伪共享演示Demo
 *
 * @author bluefish 2018/12/2
 * @version 1.0.0
 */
public class FalseSharingDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            benckMark();
        }
    }

    public static void benckMark() {
        long start = System.currentTimeMillis();
        int size = Runtime.getRuntime().availableProcessors();
        SharingLong[] shares = new SharingLong[size];

        for (int i = 0; i < size; i++) {
            shares[i] = new SharingLong();
        }

        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new LightThread(shares, i);
        }

        for (Thread t : threads) {
            t.start();
        }

        long end = System.currentTimeMillis();

        System.out.printf("Total cost %dms \n", end - start);

    }
}


class SharingLong {
    volatile long v;
//    long p1, p2, p3, p4, p5, p6;
}

class LightThread extends Thread {

    SharingLong[] shares;
    int index;

    public LightThread(SharingLong[] shares, int index) {
        this.shares = shares;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            shares[index].v++;
        }
    }
}
