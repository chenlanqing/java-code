package com.blue.fish.se.thread.juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author bluefish 2019-07-22
 * @version 1.0.0
 */
public class WriteAndReadListIterator {

    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeIf(integer -> integer.equals(4));

    }

}
