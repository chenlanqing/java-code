package com.blue.fish.se.collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class HashMapDeadLoop {

    private static Map<Long, Set<Integer>> setMap = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        final long key = 1L;
        setMap.put(key, new HashSet<Integer>());
        for (int i = 0; i < 100; i++) {
            setMap.get(key).add(i);
        }
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 100; j < 200000; j++) {
                    setMap.get(key).add(j);
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 200000; j < (200000 + 200000); j++) {
                    setMap.get(key).add(j);
                }
            }
        });
        a.start();
        b.start();
        Thread.sleep(1000 * 10);
        System.out.println(setMap.toString()); // 报java.lang.OutOfMemoryError: Java heap space
    }
}
