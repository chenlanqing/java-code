package com.blue.fish.se.collection.base;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class HashTableDemo {

    public static void main(String[] args) {
        Map hashTable = new Hashtable();
        hashTable.put("2", "hello");
        hashTable.put("1", null);
        System.out.println(hashTable);
    }
}
