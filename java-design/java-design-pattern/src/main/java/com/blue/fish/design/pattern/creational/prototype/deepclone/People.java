package com.blue.fish.design.pattern.creational.prototype.deepclone;

import lombok.Data;

import java.util.Date;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Data
public class People implements Cloneable{

    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        People p = (People) super.clone();
        p.birthday = (Date) this.birthday.clone();
        return p;
    }
}
