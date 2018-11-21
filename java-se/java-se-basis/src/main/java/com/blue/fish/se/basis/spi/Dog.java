package com.blue.fish.se.basis.spi;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class Dog implements Animal {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}