package com.blue.fish.ee.map;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过地址向高德地图获取对应地址的经纬度；
 *
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class GaodeMapDemo {

    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>();
        param.put("key", "116087e13c84a0baaaa8e18b4a103fbf");
        param.put("address", "杭州市西湖区西城广场");
        String resp = HttpUtil.get("https://restapi.amap.com/v3/geocode/geo", param);

        JSON json = JSONUtil.parse(resp);

        String location = json.getByPath("geocodes[0].location", String.class);

        String lng = location.split(",")[0];
        String lat = location.split(",")[1];

        System.out.println(lng);
        System.out.println(lat);
    }
}
