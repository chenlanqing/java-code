package com.qing.fan.common.entity;


import lombok.ToString;

@ToString
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;

    public UserInfo() {
    }

    public UserInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserInfo(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
