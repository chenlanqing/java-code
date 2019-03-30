package com.blue.fish.se.basis.jmx.demo;

/**
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public interface HelloMBean {

    String getName();

    void setName(String name);

    String getAge();

    void setAge(String age);

    void helloWorld();

    void helloWorld(String str);

    void getTelephone();
}
