package com.blue.fish.se.thread.base;

/**
 * 关于线程中异常的处理
 *
 * @author bluefish 2019-09-20
 * @version 1.0.0
 */
public class ThreadExceptionHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyExceptionHandler("自定义捕获："));

        new Thread(new ExceptionRunnable(), "线程1").start();
        new Thread(new ExceptionRunnable(), "线程2").start();
        new Thread(new ExceptionRunnable(), "线程3").start();
        new Thread(new ExceptionRunnable(), "线程4").start();
    }

    static class ExceptionRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(1 / 0);
        }
    }

    static class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
        private String name;

        public MyExceptionHandler(String name) {
            this.name = name;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + " 发生异常, 异常原因：" + e);
            System.out.println(name + " 捕获了异常：" + e.getCause());
        }
    }
}
