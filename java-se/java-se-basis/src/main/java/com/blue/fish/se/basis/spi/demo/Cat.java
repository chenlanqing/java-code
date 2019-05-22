package com.blue.fish.se.basis.spi.demo;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class Cat implements Animal {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}