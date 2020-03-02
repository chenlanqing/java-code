package com.blue.fish.se.thread.atomic;

import java.util.concurrent.atomic.DoubleAdder;

/**
 * @author bluefish 2020-03-01
 * @version 1.0.0
 */
public class DoubleAdderDemo {

    public static void main(String[] args) {
        DoubleAdder adder = new DoubleAdder();
        adder.add(12);
        adder.add(15);

        System.out.println(adder.toString());
        System.out.println(adder.sum());
    }
}
