package com.blue.fish.jvm;

import java.io.Serializable;

/**
 * @author bluefish 2019-06-16
 * @version 1.0.0
 */
public class Overload {
    public static void main(String[] args) {
        sayHello('a');
    }

    public static void sayHello(Object arg) {
        System.out.println("Hello object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable");
    }

    public static void sayHello(Comparable arg) {
        System.out.println("Hello Comparable");
    }
}
