package com.blue.fish.se.basis.oop;

/**
 * 一个类实现两个接口，这两个接口中包含相同签名的默认方法
 *
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class DefaultMethod1 {

    interface InterfaceClass1 {
        default int add(int a, int b) {
            return a + b;
        }
    }
    interface InterfaceClass2 {
        default int add(int a, int b) {
            return a + b;
        }
    }
    // 报错
//    class implClass implements InterfaceClass1, InterfaceClass2 {
//
//    }
}

