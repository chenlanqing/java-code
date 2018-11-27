package com.blue.fish.design.pattern.structural.adapter.classadapter;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void target() {
        super.adapteeRequest();
    }
}
