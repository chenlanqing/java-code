package com.blue.fish.se.basis.string;

/**
 * @author bluefish 2019-05-14
 * @version 1.0.0
 */
public class MaxStringLength {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append("a");
        }

        String s = sb.toString();

        System.out.println(s.length());
    }
}
