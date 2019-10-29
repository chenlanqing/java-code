package com.blue.fish.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印日志：-XX:+PrintGCDetails -XX:+PrintGCDateStamps
 *
 * 调整堆大小：-Xms1024M -Xmx1024M
 *
 * @author bluefish 2019-10-29
 * @version 1.0.0
 */
public class ListWithOsr {

    public static void main(String[] args) {
        /*
         一个ArrayList中连续插入1千万条数据，结果耗时不一样：第二次操作要比第一次操作要快，
         通过调大堆大小，发现第二次操作总是比第一次操作快一点
         */

        List<Integer> list0 = new ArrayList<>();
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start0);

        List<Integer> list1 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 10000000; i < 20000000; i++) {
            list1.add(i);
        }
        System.out.println(System.currentTimeMillis() - start1);


         /*
          但是分别开启两个线程，耗时是差不多的
         */
        new Thread(new ListRunnable(0, 10000000)).start();
        new Thread(new ListRunnable(10000000, 20000000)).start();
    }

    static class ListRunnable implements Runnable {

        private final int start;
        private final int len;

        public ListRunnable(int start, int len) {
            this.start = start;
            this.len = len;
        }

        @Override
        public void run() {
            List<Integer> list1 = new ArrayList<>();
            long start1 = System.currentTimeMillis();
            for (int i = start; i < len; i++) {
                list1.add(i);
            }
            System.out.println(System.currentTimeMillis() - start1);
        }
    }
}
