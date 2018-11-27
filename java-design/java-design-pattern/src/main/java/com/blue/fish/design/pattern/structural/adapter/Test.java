package com.blue.fish.design.pattern.structural.adapter;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        DC5V dc5 = new PowerAdapter();
        dc5.output5V();
    }

}
