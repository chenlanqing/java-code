package com.blue.fish.design.pattern.creational.abstractfactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class PythonVideo  extends Video{
    @Override
    public void produce() {
        System.out.println("录制Python课程");
    }
}
