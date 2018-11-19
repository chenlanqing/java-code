package com.blue.fish.se.thread.base;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author bluefish 2018/8/6
 * @version 1.0.0
 */
public class HelloWorld {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds());

        for (ThreadInfo info : threadInfo) {
            System.out.println(info.getThreadName());
        }
    }
}
