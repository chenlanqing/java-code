package com.blue.fish.se.basis.z_others;


import org.springframework.util.CollectionUtils;

import java.util.*;

public class HashDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64};

        HashSet<String> set = new HashSet<>();
        HashMap<String, List<String>> t = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            String db = "DB" + (a[i] % 4);
            set.add(db);
            List<String> tab = t.get(db);
            if (CollectionUtils.isEmpty(tab)){
                tab = new ArrayList<>();
            }
            tab.add("TABLE" + (a[i] / 4 % 16 ));
            t.put(db, tab);
        }

        List<String> sort = new ArrayList<String>(set);
        Collections.sort(sort);
        System.out.println(sort);


    }
}
