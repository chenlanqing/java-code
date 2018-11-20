package com.blue.fish.design.pattern.creational.factorymethod;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class PythomVideoFactory implements VideoFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
