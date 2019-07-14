package com.blue.fish.se.basis.z_others;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author bluefish 2019-07-13
 * @version 1.0.0
 */
public class SystemDefaultProperties {

    public static void main(String[] args) {
        Properties properties = System.getProperties();

        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
