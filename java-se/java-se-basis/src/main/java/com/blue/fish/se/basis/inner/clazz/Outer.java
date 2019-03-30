package com.blue.fish.se.basis.inner.clazz;

public class Outer {
    public void show() {
        int a = 25;
        int b = 13;
        class Inner {
            int c = 2;

            public void print() {
                System.out.println("访问外部类:" + a);
                System.out.println("访问内部类:" + c);
            }
        }
        Inner i = new Inner();
        i.print();
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        o.show();
    }
}