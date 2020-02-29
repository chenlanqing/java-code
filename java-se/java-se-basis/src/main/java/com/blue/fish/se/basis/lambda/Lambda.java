package com.blue.fish.se.basis.lambda;

public class Lambda {

    private static void lambda() {
        Runnable runnable = () -> System.out.println("lambda is run");
        runnable.run();
    }

    private static void innerClass() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("inner class is run");
            }
        };
        runnable.run();
    }

    public static void main(String[] args) throws Exception {
        lambda();
        innerClass();
    }
}