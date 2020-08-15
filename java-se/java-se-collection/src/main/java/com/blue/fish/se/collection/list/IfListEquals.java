package com.blue.fish.se.collection.list;


import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluefish 2020-04-29
 * @version 1.0.0
 */
public class IfListEquals {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("aaaa");
        list1.add("bbbb");
        list1.add("cccc");


        List<String> list2 = new ArrayList<>();
        list2.add("cccc");
        list2.add("bbbb");
        list2.add("aaaa");


        System.out.println(CollectionUtils.isEqualCollection(list1, list2));


        list1.forEach(a -> {
            if (a.equals("aaaa")) {
                return;
            }
            System.out.println(a);
        });

    }
}
