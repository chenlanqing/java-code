package com.blue.fish.se.collection.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bluefish 2019-06-28
 * @version 1.0.0
 */
public class ListAddArray {

    public static void main(String[] args) {
        List list = new ArrayList();
        char[] chars = new char[2];
        chars[0] = 'a';
        chars[1] = 'b';
        list.add(chars);
        System.out.println(list);
    }
}
