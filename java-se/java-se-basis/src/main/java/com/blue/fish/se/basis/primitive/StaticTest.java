package com.blue.fish.se.basis.primitive;

public class StaticTest {

    static int a = 10;

    static {
        a += 5;
    }


    public static void main(String[] args) {
        System.out.println(a);

//        staticFunction();
        /**输出结果：
         * 2
         * 3
         * a=110，b=0
         * 1
         * 4
         */
    }
    static {
        a /= 3;
    }


//    StaticTest st = new StaticTest();//对象的初始化是先初始化成员变量再执行构造方法
//
//    static {
//        System.out.println("1");
//    }
//
//    {
//        System.out.println("2");
//    }
//
//    StaticTest() {
//        System.out.println("3");
//        System.out.println("a=" + a + "，b=" + b);
//    }
//
//    public static void staticFunction() {
//        System.out.println("4");
//    }
//
//    int a = 110;
//    static int b = 112;
}