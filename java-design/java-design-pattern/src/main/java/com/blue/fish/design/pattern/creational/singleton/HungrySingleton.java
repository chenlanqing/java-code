package com.blue.fish.design.pattern.creational.singleton;


/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public class HungrySingleton {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    private static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}