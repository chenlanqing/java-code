package com.blue.fish.se.basis.z_others;

/**
 * @author bluefish 2018/8/15
 * @version 1.0.0
 */
public class IntOverFlow {
    public static void main(String[] args) {
//        int a = Integer.MAX_VALUE - 10;
//        int b = Integer.MAX_VALUE - 10000;
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = a + b;
        System.out.println(a + "," + b);
        boolean f1 = a > 0 && b > 0 && c < 0;
        boolean f2 = a < 0 && b < 0 && c > 0;
        System.out.println(c);
        System.out.println(f1 + "," + f2);
        System.out.println((c^a)<0 && (c ^ b)<0);
    }
}
