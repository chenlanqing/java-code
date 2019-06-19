package com.blue.fish.se.basis.string;

import java.util.Arrays;

/**
 * @author bluefish 2019-05-16
 * @version 1.0.0
 */
public class StringIndexOf {

    public static void main(String[] args) {

//        String[] split = split("a|b|c", "|");
        String[] split = "a|b|c".split("\\|");
        System.out.println(Arrays.toString(split));

    }
}
