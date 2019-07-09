package com.blue.fish.se.basis.generic;

public class GenericTypeTest {
    public static <T> T add(T x, T y) {
        return y;
    }

    public static void main(String[] args) {
        //t0编译报错：add 的两个参数一个是Integer,一个是Float,取同一父类的最小级Number,故T为Number类型,类型错误
//        int t0 = GenericTypeTest.add(10, 10.22);
        //t1执行成功,add 的两个参数都是 Integer,所以 T 为 Integer 类型
        int t1 = GenericTypeTest.add(10, 20);
        //t2执行成功,add 的两个参数一个是Integer,一个是Float,取同一父类型Number,故T为Number类型
        Number t2 = GenericTypeTest.add(10, 20.22);
        //t3执行成功,的两个参数一个是Integer,一个是Float,取同一类型的最小级Object,故T为 Object类型
        Object t3 = GenericTypeTest.add(10, "abc");
        //t4执行成功,add指定了泛型类型为 Integer,所以只能add为Integer的类型或者子类型的参数.
        int t4 = GenericTypeTest.<Integer>add(10, 20);
        //t5编译报错,同t4
//        int t5 = GenericTypeTest.<Integer>add(10, 22.22);
        //t6执行成功,add指定了泛型类型Number,add只能为Number类型或者子类型的.
        Number t6 = GenericTypeTest.<Number>add(10, 20.33);
    }
}