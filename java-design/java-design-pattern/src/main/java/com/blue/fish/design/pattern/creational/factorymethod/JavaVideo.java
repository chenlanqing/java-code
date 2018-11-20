package com.blue.fish.design.pattern.creational.factorymethod;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class JavaVideo extends Video{
    @Override
    public void produce() {
        System.out.println("录制Java课程");
    }
}
