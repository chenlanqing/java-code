package com.blue.fish.se.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JDK7版本的HashMap在多线程环境下可能发生死循环；这个在JDK8版本已经修复；<br/>
 * 但是JDK8版本下ConcurrentHashMap 也有可能发生CPU使用率接近100%，这个问题在JDK9得到修复,具体bug详情：https://bugs.openjdk.java.net/browse/JDK-8062841<br/>
 *
 * 如下代码示例，主要是因为java.util.concurrent.ConcurrentHashMap#computeIfAbsent(java.lang.Object, java.util.function.Function)的for循环导致死循环
 * @author bluefish 2018/11/30
 * @version 1.0.0
 */
public class ConcurrentHashMap100CPU {

    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>(16);
        map.computeIfAbsent(
                "AaAa",
                key -> {
                    return map.computeIfAbsent(
                            "BBBB",
                            key2 -> 42);
                }
        );

//        System.out.println("Fibonacci result for 20 is" + fibonacci(20));
    }

    static ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

    static int fibonacci(int i) {
        if (i == 0)
            return i;

        if (i == 1)
            return 1;

        return concurrentMap.computeIfAbsent(i, (key) -> {
            System.out.println("Value is " + key);
            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }

}