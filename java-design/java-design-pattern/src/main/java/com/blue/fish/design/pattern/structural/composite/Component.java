package com.blue.fish.design.pattern.structural.composite;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public abstract class Component {

    public void add(Component component){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(Component component){
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(Component component){
        throw new UnsupportedOperationException("不支持获取操作");
    }
}
