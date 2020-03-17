package com.blue.fish.se.collection.map;

import java.util.LinkedHashMap;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class LinkedHashMapLruDemo {

    public static void main(String[] args) {
        // 新建 LinkedHashMap
        LinkedHashMap<Integer, Integer> map = new LruCache<>(4, 0.75f, true);
        map.put(10, 10);
        map.put(9, 9);
        map.put(20, 20);
        map.put(1, 1);

        System.out.println(map);

        map.get(9);

        System.out.println(map);

        map.get(20);

        System.out.println(map);
    }
}
