package com.blue.fish.design.pattern.creational.singleton;

import com.blue.fish.common.annotation.ThreadSafe;

/**
 * 单例模式防止反射
 *
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@ThreadSafe
public class HungrySingletonAvoidReflection {

    private final static HungrySingletonAvoidReflection HUNGRY_SINGLETON_AVOID_REFLECTION = new HungrySingletonAvoidReflection();
    private HungrySingletonAvoidReflection(){
        if(HUNGRY_SINGLETON_AVOID_REFLECTION != null){
            throw new RuntimeException("单例不能通过反射构建实例");
        }
    }

    private static HungrySingletonAvoidReflection getInstance(){
        return HUNGRY_SINGLETON_AVOID_REFLECTION;
    }
}