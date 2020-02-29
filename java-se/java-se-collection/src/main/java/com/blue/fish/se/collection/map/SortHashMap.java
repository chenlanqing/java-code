package com.blue.fish.se.collection.map;

import com.blue.fish.common.entity.UserInfo;

import java.util.*;

/**
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class SortHashMap {

    public static void main(String[] args) {
        HashMap<Integer, UserInfo> map = new HashMap<>(3);
        map.put(1, new UserInfo(1, "张三", 28));
        map.put(2, new UserInfo(2, "李四", 22));
        map.put(3, new UserInfo(3, "王五", 26));
        System.out.println(map);

        HashMap<Integer, UserInfo> sortMap = sortMap(map);

        System.out.println(sortMap);
    }

    private static HashMap<Integer, UserInfo> sortMap(HashMap<Integer, UserInfo> map) {
        Set<Map.Entry<Integer, UserInfo>> entrySet = map.entrySet();

        ArrayList<Map.Entry<Integer, UserInfo>> list = new ArrayList<>(entrySet);

        list.sort(Comparator.comparingInt(o -> o.getValue().getAge()));

        LinkedHashMap<Integer, UserInfo> result = new LinkedHashMap<>();

        list.forEach(s -> result.put(s.getKey(), s.getValue()));

        return result;
    }
}
