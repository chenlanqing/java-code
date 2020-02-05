package com.blue.fish.se.collection.base;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author bluefish 2020-01-16
 * @version 1.0.0
 */
public class ListToArray {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        // 编译报错，因为 list.toArray() 返回的是 Object[]，无法转换，强转也不行
//         Integer[] source = list.toArray();

        // list.toArray有参数的方法，传入一个数组，但是数组的长度小于集合的长度，那么source里面的元素都是null；
        // 但是方法的返回值是包含所有元素的
        Integer[] source = new Integer[2];
        Integer[] arr = list.toArray(source);
        System.out.println(Arrays.toString(source)); // [null, null]
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4]

        // list.toArray有参数的方法，传入一个数组，但是数组的长度等于集合的长度，那么source里面的元素都是集合的元素的
        // 但是方法的返回值是包含所有元素的
        Integer[] source1 = new Integer[4];
        Integer[] arr1 = list.toArray(source1);
        System.out.println(Arrays.toString(source1)); // [1, 2, 3, 4]
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4]

        // list.toArray有参数的方法，传入一个数组，但是数组的长度大于集合的长度，那么source里面的元素都是集合的元素的，数组的对于元素为null
        // 但是方法的返回值是包含所有元素的，数组的对于元素为null
        Integer[] source2 = new Integer[6];
        Integer[] arr2 = list.toArray(source2);
        System.out.println(Arrays.toString(source2)); // [1, 2, 3, 4, null, null]
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4, null, null]
    }
}
