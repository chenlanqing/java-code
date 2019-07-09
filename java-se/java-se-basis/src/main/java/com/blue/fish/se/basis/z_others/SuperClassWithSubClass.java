package com.blue.fish.se.basis.z_others;

public class SuperClassWithSubClass {
    private String baseName = "base";

    public SuperClassWithSubClass() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends SuperClassWithSubClass {
        private String baseName = "sub";

        public void callName() {
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        SuperClassWithSubClass b = new Sub();
    }
}