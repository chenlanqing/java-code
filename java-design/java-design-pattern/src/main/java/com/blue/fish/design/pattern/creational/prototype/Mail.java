package com.blue.fish.design.pattern.creational.prototype;

import lombok.Data;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Data
public class Mail implements Cloneable{

    private String name;
    private String emailAddress;
    private String content;

    public Mail(){
        System.out.println("Mail Class Constructor");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
