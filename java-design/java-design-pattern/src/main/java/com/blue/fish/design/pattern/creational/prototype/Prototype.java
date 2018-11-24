package com.blue.fish.design.pattern.creational.prototype;

import lombok.Data;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Data
public class Prototype implements Cloneable{
    private String name;
    private int age;

    public Prototype() {
        this.name = "Jayden";
        this.age = 30;
    }

    public void change(){
        this.name = "Holiday";
        this.age = 28;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p = new Prototype();
        p.change();
        System.out.println(p);
        Prototype clone = (Prototype) p.clone();
        System.out.println(clone);
    }
}
