package com.blue.fish.se.basis.lambda;

/**
 * @author bluefish 2019-05-14
 * @version 1.0.0
 */
public class LambdaDemo {


    public static void runThreadUseLambda() {
        new Thread(() -> System.out.println("我是Lambda线程")).start();
    }

    public static void runWithInnerClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类线程");
            }
        }).start();
    }

    public static void main(String[] args) {
        runThreadUseLambda();

        runWithInnerClass();
    }
}
