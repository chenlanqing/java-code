package com.blue.fish.se.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author bluefish 2020-01-16
 * @version 1.0.0
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("11");
        set.add("66");
        set.add("33");
        set.add("55");
        set.add("22");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
