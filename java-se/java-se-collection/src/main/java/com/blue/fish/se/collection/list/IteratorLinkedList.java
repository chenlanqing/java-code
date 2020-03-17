package com.blue.fish.se.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class IteratorLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<Integer> listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
