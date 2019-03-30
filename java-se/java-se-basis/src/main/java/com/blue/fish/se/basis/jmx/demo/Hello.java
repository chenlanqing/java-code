package com.blue.fish.se.basis.jmx.demo;

/**
 * @author bluefish 2019-03-30
 * @version 1.0.0
 */
public class Hello implements HelloMBean {
    private String name;

    private String age;

    public void getTelephone() {
        System.out.println("get Telephone");
    }

    public void helloWorld() {
        System.out.println("hello world");
    }

    public void helloWorld(String str) {
        System.out.println("helloWorld:" + str);
    }

    public String getName() {
        System.out.println("get Name:" + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("set name:" + name);
        this.name = name;
    }

    public String getAge() {
        System.out.println("get age:" + age);
        return age;
    }

    public void setAge(String age) {
        System.out.println("set age:" + age);
        this.age = age;
    }
}
