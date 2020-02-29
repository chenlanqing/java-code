package com.blue.fish.se.basis.oop;

public class NullArguementOverloading {
    public static void main(String[] args) {
        NullArguementOverloading obj = new NullArguementOverloading();
        obj.overLoad(null); // Double array argument method.
    }

    private void overLoad(Object o) { // 1
        System.out.println("Object o arguement method.");
    }

    private void overLoad(double[] dArray) { //2
        System.out.println("Double array argument method.");
    }

//    private void overLoad(String str) { //3
//        System.out.println("String argument method.");
//    }
}