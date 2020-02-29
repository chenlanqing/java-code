package com.blue.fish.se.basis.oop;

/**
 * 一个类实现一个接口，一个抽象类，抽象类定义了一个和接口的默认方法相同的抽象方法，则在类中需要实现该方法
 *
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class DefaultMethod2 {

    interface InterfaceClass1 {
        default int add(int a, int b) {
            return a + b;
        }
    }
    abstract class AbsClass2 {
        abstract int add(int a, int b);
    }
    // 实现类必须实现 方法
    class implClass extends AbsClass2 implements InterfaceClass1 {
        public int add(int a, int b){
            return a + b;
        }
    }
}

