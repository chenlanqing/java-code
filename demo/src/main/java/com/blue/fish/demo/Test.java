package com.blue.fish.demo;

/**
 * @author bluefish 2019-07-07
 * @version 1.0.0
 */
public class Test {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static final int RUNNING    = -1 << COUNT_BITS;
    // 000 00000000000000000000000000000
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    // 001 00000000000000000000000000000
    private static final int STOP       =  1 << COUNT_BITS;
    // 010 00000000000000000000000000000
    private static final int TIDYING    =  2 << COUNT_BITS;
    // 011 00000000000000000000000000000
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println(CAPACITY);
    }
}
