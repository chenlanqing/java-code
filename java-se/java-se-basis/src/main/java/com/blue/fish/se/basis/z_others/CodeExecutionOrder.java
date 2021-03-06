package com.blue.fish.se.basis.z_others;

/**
 * 测试代码执行顺序
 *
 * @author bluefish 2018/8/18
 * @version 1.0.0
 */
public class CodeExecutionOrder {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A(int v){
            setValue(v);
        }
        public void setValue(int value) { this.value = value;}
        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B(){
            super(5);
            setValue(getValue() - 3);
        }
        public void setValue(int value) {super.setValue(2 * value);}
    }
}
