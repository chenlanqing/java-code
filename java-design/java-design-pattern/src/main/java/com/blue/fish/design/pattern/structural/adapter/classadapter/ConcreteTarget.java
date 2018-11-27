package com.blue.fish.design.pattern.structural.adapter.classadapter;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
public class ConcreteTarget implements Target {
    @Override
    public void target() {
        System.out.println("ConcreteTarget目标方法");
    }
}
