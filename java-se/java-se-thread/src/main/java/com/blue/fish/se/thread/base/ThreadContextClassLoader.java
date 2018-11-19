package com.blue.fish.se.thread.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/5/27
 * @version 1.0.0
 */
@Slf4j
public class ThreadContextClassLoader {

    public static void main(String[] args) {
        ClassLoader classLoader = ThreadContextClassLoader.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

    }
}
