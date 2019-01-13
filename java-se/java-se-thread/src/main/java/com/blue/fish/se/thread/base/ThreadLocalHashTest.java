package com.blue.fish.se.thread.base;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author bluefish 2019-01-13
 * @version 1.0.0
 */
public class ThreadLocalHashTest {

    private static AtomicInteger nextHashCode = new AtomicInteger();

    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.print(nextHashCode() & 15);
            System.out.print("  ");
        }
        System.out.println();

        for (int i = 0; i < 32; i++) {
            System.out.print(nextHashCode() & 31);
            System.out.print("  ");
        }
        System.out.println();

        for (int i = 0; i < 64; i++) {
            System.out.print(nextHashCode() & 63);
            System.out.print("  ");
        }
        System.out.println();
    }
}
