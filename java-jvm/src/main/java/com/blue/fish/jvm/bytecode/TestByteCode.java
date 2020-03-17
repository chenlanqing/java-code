package com.blue.fish.jvm.bytecode;

/**
 * @author bluefish 2020-03-16
 * @version 1.0.0
 */
public class TestByteCode {
    private volatile int a = 8;

    public static void main(String[] args) {
        TestByteCode t = new TestByteCode();
        t.a = 10;
    }
}
