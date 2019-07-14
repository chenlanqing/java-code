package com.blue.fish.jvm.gc;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制GC执行次数
 * <p>
 * 需求：写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，请给出代码以及启动参数。
 * VM设置：-Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * -Xms41m 				堆最小值
 * -Xmx41m 				堆最大值
 * -Xmn10m 				新生代大小大小(推荐 3/8)
 * -XX:+UseParallelGC   使用并行收集器
 *
 * <p>
 * 初始化时：835k(堆内存)
 * 第一次add：3907k
 * 第二次add：6979k
 * 第三次add: eden + survivor1 = 9216k < 6979k + 3072k,区空间不够，开始 YGC
 * YGC  6979k -> 416k(9216k) 表示年轻代 GC前为6979，GC后426k.年轻代总大小9216k
 *
 * @author bluefish 2019-07-14
 * @version 1.0.0
 */
public class ControlYgcAndFgc {

    private static final int _1_MB = 1024 * 1024;

    public static void main(String[] args) {
        List caches = new ArrayList();

        System.out.println("--初始化时已用堆值:" + ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1024 + "k");
        for (int i = 1; i <= 12; i++) {
            caches.add(new byte[3 * _1_MB]);
        }
        // 释放空间，重新添加 ,如果不释放空间，会报错：java.lang.OutOfMemoryError: Java heap space 【这里这样做，主要为了防止数组对象实际大小超过堆大小】
        caches.remove(0);

        caches.add(new byte[3 * _1_MB]);

        // 这里是为了下次FGC后，直接减少老年代的内存大小，从而正常YGC
        for (int i = 0; i < 8; i++) {
            caches.remove(0);
        }

        caches.add(new byte[3 * _1_MB]);

        for (int i = 0; i < 6; i++) {
            caches.add(new byte[3 * _1_MB]);
        }
    }

}
