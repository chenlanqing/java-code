package com.blue.fish.se.thread.base;

/**
 * 子线程能够看到父线程设置的变量
 *
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class ParentThreadSharedDataWithSon {
    // 使用InheritableThreadLocal来构建ThreadLocal，子线程能看到父线程设置的变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
//    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("Hello 子线程");

        Thread thread = new Thread(()->{
            System.out.println(threadLocal.get());
        });

        thread.start();

        System.out.println("Main Thread:" + threadLocal.get());
    }

}
