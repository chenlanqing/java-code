package com.blue.fish.se.basis.z_others;

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b)); //  1--A and A
        System.out.println("2--" + a1.show(c)); //  2--A and A
        System.out.println("3--" + a1.show(d)); //  3--A and D
        System.out.println("4--" + a2.show(b)); //  4--B and A
        System.out.println("5--" + a2.show(c)); //  5--B and A
        System.out.println("6--" + a2.show(d)); //  6--A and D
        System.out.println("7--" + b.show(b));  //  7--B and B
        System.out.println("8--" + b.show(c));  //  8--B and B
        System.out.println("9--" + b.show(d));  //  9--A and D
    }

    static class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }
    }

    static class B extends A {
        public String show(B obj) {
            return ("B and B");
        }

        public String show(A obj) {
            return ("B and A");
        }
    }

    static class C extends B {
    }

    static class D extends B {
    }
}

