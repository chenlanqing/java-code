package com.blue.fish.se.basis.z_others;

/**
 * @author bluefish 2019-07-09
 * @version 1.0.0
 */
public class NullKeyWordTest {


    public static void main(String[] args) {
        Object o = (Object) null;
        Integer i = (Integer) null;
        String s = (String) null;
        Null n = (Null) null;
        System.out.println(o);
        System.out.println(i);
        System.out.println(s);
        System.out.println(n);
        n.test();
    }
}
