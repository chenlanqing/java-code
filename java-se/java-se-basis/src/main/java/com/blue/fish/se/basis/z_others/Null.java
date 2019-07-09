package com.blue.fish.se.basis.z_others;

public class Null {
    public static void nihao() {
        System.out.println("你好陌生人");
    }

    public static void main(String[] args) {
        ((Null) null).nihao();
    }

    public void test(){
        System.out.println("Test...");
    }
}