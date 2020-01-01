package com.blue.fish.jvm.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟堆内存溢出
 * <p>
 * 虚拟机参数：-Xmx32M -Xms32M
 * <p>
 * 导出dump文件：-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=<>
 *
 * @author bluefish 2019-06-17
 * @version 1.0.0
 */
public class HeapOutOfMemory {

    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        for (int i = 0; i < 128; i++) {
            Thread.sleep(100);
            map.put(i, new byte[1024 * 1024]);
        }
    }
}
