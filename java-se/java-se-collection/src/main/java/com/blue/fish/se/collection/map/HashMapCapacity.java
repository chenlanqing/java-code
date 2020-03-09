package com.blue.fish.se.collection.map;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author bluefish 2020-03-09
 * @version 1.0.0
 */
public class HashMapCapacity {

    public static void main(String[] args)throws Exception {
        HashMap<String, String> map = new HashMap<>(16);
        HashMap<String, String> map1 = new HashMap<>(17);

        Class<? extends HashMap> m1Class = map.getClass();
        Field t1 = m1Class.getDeclaredField("threshold");
        t1.setAccessible(true);
        System.out.println(t1.get(map));

        Class<? extends HashMap> m2Class = map1.getClass();
        Field t2 = m2Class.getDeclaredField("threshold");
        t2.setAccessible(true);
        System.out.println(t2.get(map1));
    }
}
