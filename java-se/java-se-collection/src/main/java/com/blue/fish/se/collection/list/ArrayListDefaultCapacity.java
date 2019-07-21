package com.blue.fish.se.collection.list;

import java.util.ArrayList;

/**
 * @author bluefish 2019-07-16
 * @version 1.0.0
 */
public class ArrayListDefaultCapacity {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Class<? extends ArrayList> clazz = list.getClass();
    }
}

