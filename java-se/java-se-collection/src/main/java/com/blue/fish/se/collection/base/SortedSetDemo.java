package com.blue.fish.se.collection.base;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet set = new TreeSet();
        set.add("1");
        set.add(1);
        // 抛异常
        System.out.println(set);
    }
}
