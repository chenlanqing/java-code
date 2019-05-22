package com.blue.fish.se.basis.enums;

/**
 * @author bluefish 2019-05-15
 * @version 1.0.0
 */
public enum EnumDemo {

    SUCCESS{
        @Override
        void print() {
            System.out.println("SUCCESS");
        }
    };

    abstract void print();
}
