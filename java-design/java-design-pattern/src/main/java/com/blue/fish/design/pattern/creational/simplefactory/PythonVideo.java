package com.blue.fish.design.pattern.creational.simplefactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class PythonVideo implements Video{
    @Override
    public void produce() {
        System.out.println("录制python课程");
    }
}
