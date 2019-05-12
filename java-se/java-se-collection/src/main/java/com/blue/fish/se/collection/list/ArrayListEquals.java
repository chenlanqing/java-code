package com.blue.fish.se.collection.list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bluefish 2019-01-09
 * @version 1.0.0
 */
public class ArrayListEquals {

    public static void main(String[] args) {
        Set<UserInfo> set = new HashSet<>();

        int total = 0;
        for (int i = 0; i < 10; i++) {
            UserInfo u = new UserInfo();
            u.setId(i + 1);
            u.setName("TEST" + (i+1));
            u.setAge((i+1) * 10);
            u.setAddress(UUID.randomUUID().toString());
            set.add(u);
            total += u.getAge();
        }
        System.out.println("Total=" + total);
        System.out.println(set);
        List<UserInfo> list = new ArrayList<>(set);
        System.out.println(list);

        list.sort(Comparator.comparing(UserInfo::getId));
        System.out.println(list);
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(UserInfo::getAge));
        System.out.println(collect);
        System.out.println((Integer) list.stream().mapToInt(UserInfo::getAge).sum());
    }
}
