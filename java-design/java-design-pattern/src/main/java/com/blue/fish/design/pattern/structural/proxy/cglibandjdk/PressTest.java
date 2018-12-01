package com.blue.fish.design.pattern.structural.proxy.cglibandjdk;

import com.blue.fish.design.pattern.structural.proxy.cglib.SubjectInterceptor;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
@Slf4j
public class PressTest {

    private static int creation = 100000000;
    private static int execution = 1000000000;

    public static void main(String[] args) throws IOException {
        testJDKDynamicCreation();
        testJDKDynamicExecution();
        testCglibCreation();
        testCglibExecution();
    }

    private static void testJDKDynamicCreation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < creation; i++) {
            InvocationHandler handler = new JDKProxyHandler(ConcreteSubject.class);
            Proxy.newProxyInstance(PressTest.class.getClassLoader(),
                    new Class[]{ISubject.class}, handler);
        }
        long stop = System.currentTimeMillis();
        log.info("JDK creation time : {} ms", stop - start);
    }

    private static void testJDKDynamicExecution() {
        long start = System.currentTimeMillis();
        InvocationHandler handler = new JDKProxyHandler(ConcreteSubject.class);
        ISubject subject =
                (ISubject) Proxy.newProxyInstance(PressTest.class.getClassLoader(),
                        new Class[]{ISubject.class}, handler);
        for (int i = 0; i < execution; i++) {
            subject.action();
        }
        long stop = System.currentTimeMillis();
        log.info("JDK execution time : {} ms", stop - start);
    }

    private static void testCglibCreation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < creation; i++) {
            MethodInterceptor methodInterceptor = new SubjectInterceptor();
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(ConcreteSubject.class);
            enhancer.setCallback(methodInterceptor);
            enhancer.create();
        }
        long stop = System.currentTimeMillis();
        log.info("cglib creation time : {} ms", stop - start);
    }

    private static void testCglibExecution() {
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteSubject.class);
        enhancer.setCallback(methodInterceptor);
        ISubject subject = (ISubject) enhancer.create();
        long start = System.currentTimeMillis();
        for (int i = 0; i < execution; i++) {
            subject.action();
        }
        long stop = System.currentTimeMillis();
        log.info("cglib execution time : {} ms", stop - start);
    }
}
