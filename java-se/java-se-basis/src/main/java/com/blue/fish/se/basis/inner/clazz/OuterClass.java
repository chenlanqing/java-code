package com.blue.fish.se.basis.inner.clazz;

import java.util.Calendar;
import java.util.Date;

/**
 * @author bluefish 2019-01-09
 * @version 1.0.0
 */
public class OuterClass {

    static class InnerClass{
        static int one = 5;
        static final int two = 5;
        static final int three = new Integer(5);
    }

    public static void main(String[] args) {
        System.out.println(InnerClass.one);
        System.out.println(InnerClass.two);
        System.out.println(InnerClass.three);

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(Calendar.getInstance().getTime().getTime());
    }
}
