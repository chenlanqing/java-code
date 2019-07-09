package com.blue.fish.se.basis.inner.clazz;

/**
 * 成员变量内部类
 */
public class VariableInnerClass {
    private int age = 99;
    String name = "Coco";

    public class InnerClass {
        String name = "Jayden";

        public void show() {
            System.out.println(VariableInnerClass.this.name);
            System.out.println(name);
            System.out.println(age);
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public static void main(String[] args) {
        VariableInnerClass o = new VariableInnerClass();
        InnerClass in = o.new InnerClass();
        in.show();
    }
}