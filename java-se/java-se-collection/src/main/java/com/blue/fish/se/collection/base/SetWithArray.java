package com.blue.fish.se.collection.base;

import java.util.HashSet;
import java.util.Set;

/**
 * @author bluefish 2019-07-07
 * @version 1.0.0
 */
public class SetWithArray {

    public static void main(String[] args) {
        Set<int[]> array = new HashSet<>();

        int[] arr1 = {1,2};
        int[] arr2 = {1,2};

        array.add(arr1);
        array.add(arr2);

        System.out.println(array);
    }
}
