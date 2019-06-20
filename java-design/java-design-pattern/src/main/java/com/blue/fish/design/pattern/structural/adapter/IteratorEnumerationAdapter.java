package com.blue.fish.design.pattern.structural.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 将一个迭代器适配为枚举
 *
 * @author bluefish 2019-06-19
 * @version 1.0.0
 */
public class IteratorEnumerationAdapter<T> implements Enumeration<T> {

    private Iterator<T> iterator;

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return iterator.next();
    }
}
