package com.blue.fish.se.collection.base;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class LinkedHashMapSort {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            linkedHashMap();
        }
        System.out.println("~~~~~~~~");
        for (int i = 0; i < 10; i++) {
            hashMap();
        }
    }

    public static void linkedHashMap() {
        Map hashMap = new LinkedHashMap();
        hashMap.put("4", "bbb");
        hashMap.put("3", "ccc");
        hashMap.put("5", "ddd");
        hashMap.put("8", "ggg");
        hashMap.put("1", "aaa");

        System.out.println(hashMap);
    }
    public static void hashMap() {
        Map hashMap = new HashMap();
        hashMap.put("4", "bbb");
        hashMap.put("33", "ccc");
        hashMap.put("15", "ddd");
        hashMap.put("8", "ggg");
        hashMap.put("1", "aaa");

        System.out.println(hashMap);
    }
}
