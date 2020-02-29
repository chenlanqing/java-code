package com.blue.fish.se.basis.primitive;

/**
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class RoundApi {

    public static void main(String[] args) {
        double d1 = -0.5;
        System.out.println("Ceil d1=" + Math.ceil(d1)); // -0.0
        System.out.println("floor d1=" + Math.floor(d1)); // -1.0
        System.out.println("floor d1=" + Math.round(d1)); // 0
        System.out.println(Math.ceil(-0)); // 0.0
        System.out.println(Math.ceil(-0.0)); // -0.0
        System.out.println(Math.floor(-0)); // 0.0
        System.out.println(Math.floor(-0.0)); // -0.0

        System.out.println(Math.ceil(d1) == (-Math.floor(-d1)));
    }
}
