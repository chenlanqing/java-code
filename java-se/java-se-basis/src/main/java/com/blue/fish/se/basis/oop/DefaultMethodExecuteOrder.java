package com.blue.fish.se.basis.oop;

/**
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class DefaultMethodExecuteOrder implements A, B {

    public static void main(String[] args) {
        new DefaultMethodExecuteOrder().hello();
    }
}

interface A {
    default void hello() {
        System.out.println("Interface A hello ： A");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("Interface B hello ： B");
    }
}
