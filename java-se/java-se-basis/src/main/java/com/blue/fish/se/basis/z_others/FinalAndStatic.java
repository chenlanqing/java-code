package com.blue.fish.se.basis.z_others;

/**
 * @author bluefish 2020-02-29
 * @version 1.0.0
 */
public class FinalAndStatic {

    public static void main(String[] args) {
        MyDemo1 d1 = new MyDemo1();
        MyDemo1 d2 = new MyDemo1();
        System.out.println(d1.i);
        System.out.println(d2.i);
        System.out.println(d1.j);
        System.out.println(d2.j);
    }

    static class MyDemo1 {
        public final double i = Math.random();
        public static double j = Math.random();
    }
}
