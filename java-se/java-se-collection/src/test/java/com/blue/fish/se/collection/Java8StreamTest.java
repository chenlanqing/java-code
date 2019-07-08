package com.blue.fish.se.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class Java8StreamTest {

    @Test
    public void forEachTest() {
        // 使用 forEach 输出了10个随机数
        Random random = new Random(100);
        random.ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void mapTest() {
        // map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数
        List<Integer> list = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> result = list.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(result);
    }

    @Test
    public void filterTest() {
        // filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = list.stream().filter(String::isEmpty).count();
        System.out.println(count);
    }
}
