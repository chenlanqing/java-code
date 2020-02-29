package com.blue.fish.se.basis.primitive;

/**
 * @author bluefish 2019-07-20
 * @version 1.0.0
 */
public class LongDivision {

    private static final long mil_seconds = 24 * 60 * 60 * 1000;

    private static final long micro_seconds = 24 * 60 * 60 * 1000 * 1000L;

    public static void main(String[] args) {
        System.out.println(micro_seconds / mil_seconds);

        double x = 2.0;
        int y = 4;

        System.out.println(x /= ++y);
    }
}
