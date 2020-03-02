package com.blue.fish.se.basis.inner.clazz;

/**
 * 静态内部类
 */
public class StaticInnerClass {

    private Integer age = 30;
    private static String name = "sum";
    private static int one = 10;

    static class InnerClass {
        static int one = 5;
        static final int two = 5;
        static final int three = new Integer(5);

        public void show() {
            System.out.println(new StaticInnerClass().age);
            System.out.println(name);
            System.out.println(StaticInnerClass.one);
        }
    }

    public static void main(String[] args) {
        InnerClass i = new InnerClass();
        i.show();

        System.out.println(InnerClass.one);
        System.out.println(InnerClass.two);
        System.out.println(InnerClass.three);

    }

}
