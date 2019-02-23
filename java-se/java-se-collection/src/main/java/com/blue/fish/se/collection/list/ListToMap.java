package com.blue.fish.se.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bluefish 2019-01-30
 * @version 1.0.0
 */
public class ListToMap {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAddress("b");
        userInfo.setAge(20);
        userInfo.setId(2);
        userInfo.setName("zhangsan");

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setAddress("a");
        userInfo1.setAge(30);
        userInfo1.setId(1);
        userInfo1.setName("wusangd");

        List<UserInfo> list = new ArrayList<>();
        list.add(userInfo);
        list.add(userInfo1);

        Map<Integer, UserInfo> collect = list.stream().collect(Collectors.toMap(UserInfo::getId, UserInfo -> UserInfo, (String, UserInfo) -> String));

        System.out.println(collect);

    }
}
