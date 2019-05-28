package com.blue.fish.se.thread.pool;

public class RewriteUncatchtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("我捕获到了线程池的异常");
    }
}