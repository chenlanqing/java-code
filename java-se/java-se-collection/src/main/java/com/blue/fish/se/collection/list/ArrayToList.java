package com.blue.fish.se.collection.list;

import java.util.Arrays;
import java.util.List;

/**
 * @author bluefish 2019-07-09
 * @version 1.0.0
 */
public class ArrayToList {

    public static void main(String[] args) {
        int[] datas = new int[]{1, 2, 3, 4, 5};
        List list = Arrays.asList(datas);
        System.out.println(list.size()); // 1
        System.out.println(list);
    }
}
