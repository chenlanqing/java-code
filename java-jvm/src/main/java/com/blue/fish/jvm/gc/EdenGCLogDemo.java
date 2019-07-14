package com.blue.fish.jvm.gc;

/**
 * @author bluefish 2019-07-14
 * @version 1.0.0
 */
public class EdenGCLogDemo {

    public static void main(String[] args) {
        testAllocation();
    }

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }
}
