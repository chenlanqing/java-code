package com.blue.fish.design.pattern.creational.prototype.abstractprototype;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
public abstract class Person implements Cloneable{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
