package com.blue.fish.spring.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author bluefish 2020-03-09
 * @version 1.0.0
 */
public class TestCgLib {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2 = (TargetObject) enhancer.create();
        System.out.println(targetObject2);
        System.out.println(targetObject2.method1("mmm1"));
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }
}
