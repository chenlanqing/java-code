package com.blue.fish.se.collection.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add("1");
        System.out.println(hashSet);
    }
}
