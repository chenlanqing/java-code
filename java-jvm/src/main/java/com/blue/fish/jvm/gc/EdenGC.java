package com.blue.fish.jvm.gc;

/**
 * -verbose:gc -Xms15M -Xmx15M -Xmn8M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author bluefish 2018/11/19
 * @version 1.0.0
 */
public class EdenGC {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
