package com.blue.fish.se.basis.reflect;

import java.lang.reflect.Method;

/**
 * @author bluefish 2019-06-24
 * @version 1.0.0
 */
public class TestMethoInvokeStack {
    // v0 版本
    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("com.blue.fish.se.basis.reflect.TestMethoInvokeStack");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, 0);
        }
    }
/**
 # 不同版本的输出略有不同，这里我使用了 Java 10。
 $ java Test
 java.lang.Exception: #0
 at Test.target(Test.java:5)
 at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke0(Native Method)
 a      t java.base/jdk.internal.reflect.NativeMethodAccessorImpl. .invoke(NativeMethodAccessorImpl.java:62)
 t       java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.i .invoke(DelegatingMethodAccessorImpl.java:43)
 java.base/java.lang.reflect.Method.invoke(Method.java:564)
 t        Test.main(Test.java:131
 */
}
