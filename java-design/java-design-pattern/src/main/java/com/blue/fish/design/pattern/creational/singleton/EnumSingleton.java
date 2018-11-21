package com.blue.fish.design.pattern.creational.singleton;

/**
 * @author bluefish 2018/11/21
 * @version 1.0.0
 */
public enum  EnumSingleton {
    INSTANCE {
        @Override
        public void print() {
            System.out.println("Singleton Enum");
        }
    };

    public abstract void print();

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}