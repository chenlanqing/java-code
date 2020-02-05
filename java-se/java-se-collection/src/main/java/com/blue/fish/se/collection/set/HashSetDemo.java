package com.blue.fish.se.collection.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add("1");
//        System.out.println(hashSet);

        Iterator iterator = hashSet.iterator();
    }
}
