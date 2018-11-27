package com.blue.fish.design.pattern.structural.adapter.objectadapter;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class Adapter implements Target{

    private Adaptee target;

    @Override
    public void target() {
        target.adapteeRequest();
    }
}
