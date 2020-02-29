package com.blue.fish.se.basis.oop;

/**
 * 一个类实现一个接口，一个抽象类，抽象类定义了一个和接口的默认方法相同的方法，可以通过缩小抽象类的访问权限：private，或者子类实现都可以
 *
 * @author bluefish 2020-02-28
 * @version 1.0.0
 */
public class DefaultMethod3 {

    interface InterfaceClass1 {
        default int add(int a, int b) {
            return a + b;
        }
    }

    abstract class AbsClass2 {
        int add(int a, int b) {
            return a + b;
        }
    }

    // 报错
    class implClass extends AbsClass2 implements InterfaceClass1 {
        @Override
        public int add(int a, int b) {
            return 0;
        }
    }
}

