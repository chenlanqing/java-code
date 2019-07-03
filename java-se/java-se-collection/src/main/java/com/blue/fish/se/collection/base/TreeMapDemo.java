package com.blue.fish.se.collection.base;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map treeMap = new TreeMap();
        treeMap.put("2", "Hello");
        treeMap.put("1", "World");
        System.out.println(treeMap);
    }
}
