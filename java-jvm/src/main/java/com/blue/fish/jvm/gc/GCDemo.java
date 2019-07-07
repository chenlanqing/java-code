package com.blue.fish.jvm.gc;

/**
 * 模拟不同的GC参数
 * <p>
 * 使用Serial GC垃圾收集器：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDetailsStamps -XX:+UseSerialGC
 * <p>
 * 使用Serial GC + CMS 垃圾收集器：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDetailsStamps -XX:+UseSerialGC -XX:+UseConcMarkSweepGC 会存在垃圾收集器冲突
 * <p>
 * 使用Parallel GC垃圾收集器：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDetailsStamps -XX:+UseParallelGC
 * <p>
 * 使用CMS 垃圾收集器：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDetailsStamps -XX:+UseConcMarkSweepGC
 * CMS垃圾收集器可以配合参数：-XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly
 * <p>
 * 使用G1垃圾收集器：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintGCDetailsStamps -XX:+UseG1GC
 *
 * @author bluefish 2019-07-07
 * @version 1.0.0
 */
public class GCDemo {


    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        byte[] a1 = new byte[2 * _1MB];
        byte[] a2 = new byte[2 * _1MB];
        byte[] a3 = new byte[2 * _1MB];
        byte[] a4 = new byte[4 * _1MB];

        Thread.sleep(5000);
        System.gc();
    }
}
