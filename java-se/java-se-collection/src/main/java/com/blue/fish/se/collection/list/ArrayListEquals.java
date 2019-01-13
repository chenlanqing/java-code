package com.blue.fish.se.collection.list;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author bluefish 2019-01-09
 * @version 1.0.0
 */
public class ArrayListEquals {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("this is list");


        Vector<String> vector = new Vector<>();
        vector.add("this is list");

        System.out.println(list.equals(vector));

    }
}
