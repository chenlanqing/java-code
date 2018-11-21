package com.blue.fish.design.pattern.creational.singleton;

import com.blue.fish.common.annotation.ThreadSafe;

import java.io.Serializable;

/**
 * 防止序列化
 *
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
@ThreadSafe
public class HungrySingletonAvoidSerialize implements Serializable{

    private static final long serialVersionUID = -7806464383852221926L;
    private final static HungrySingletonAvoidSerialize HUNGRY_SINGLETON_AVOID_SERIALIZE = new HungrySingletonAvoidSerialize();

    private HungrySingletonAvoidSerialize(){}

    private static HungrySingletonAvoidSerialize getInstance(){
        return HUNGRY_SINGLETON_AVOID_SERIALIZE;
    }

    /**
     * 防止序列化
     * @return
     */
    private Object readResolve(){
        return HUNGRY_SINGLETON_AVOID_SERIALIZE;
    }
}