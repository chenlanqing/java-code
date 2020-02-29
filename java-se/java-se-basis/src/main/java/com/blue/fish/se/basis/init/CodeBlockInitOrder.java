package com.blue.fish.se.basis.init;

/**
 * @author bluefish 2020-02-29
 * @version 1.0.0
 */
public class CodeBlockInitOrder {

    static int a;

    static {
        System.out.println("静态代码块");
    }

    public CodeBlockInitOrder() {
        System.out.println("构造函数");
    }

    {
        System.out.println("构造代码块");
    }

    public static void main(String[] args) {
        new CodeBlockInitOrder();
        System.out.println(CodeBlockInitOrder.a);
    }
}
