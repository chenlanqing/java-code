package com.blue.fish.design.pattern.structural.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 将一个枚举适配成迭代器
 *
 * @author bluefish 2019-06-19
 * @version 1.0.0
 */
public class EnumerationIteratorAdapter<T> implements Iterator<T> {

    private Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
