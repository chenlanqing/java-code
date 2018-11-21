package com.blue.fish.se.basis.spi;

import java.util.ServiceLoader;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceLoader<Animal> shouts = ServiceLoader.load(Animal.class);
        for (Animal s : shouts) {
            s.shout();
        }
    }
}