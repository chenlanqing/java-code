package com.blue.fish.se.thread.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 通过ThreadMXBean发现死锁
 *
 * @author bluefish 2019-05-23
 * @version 1.0.0
 */
public class DeadLockFoundByMXBean {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        DeadLockThread t1 = new DeadLockThread(obj1, obj2);
        DeadLockThread t2 = new DeadLockThread(obj2, obj1);

        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        MonitorThread mt = new MonitorThread();
        mt.start();
    }

    static class MonitorThread extends Thread {
        @Override
        public void run() {
            ThreadMXBean tmx = ManagementFactory.getThreadMXBean();
            long[] ids = tmx.findDeadlockedThreads();
            if (ids != null) {
                ThreadInfo[] infos = tmx.getThreadInfo(ids, true, true);
                System.out.println("The following threads are dead locked：");
                for (ThreadInfo info : infos) {
                    System.out.println(info);
                }
            }
        }
    }

    static class DeadLockThread extends Thread {
        private Object obj1;
        private Object obj2;

        public DeadLockThread(Object obj1, Object obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            synchronized (obj1) {
                try {
                    Thread.sleep(1000);
                    synchronized (obj2) {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
