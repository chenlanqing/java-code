package com.blue.fish.jvm.oom;

import com.blue.fish.jvm.AsmClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟非堆内存溢出（方法区或者叫metaspace）
 * <p>
 * 虚拟机参数（JDK8）：-XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
 *
 * @author bluefish 2019-06-17
 * @version 1.0.0
 */
public class NonHeapOutOfMemory {


    private static List<Class> classList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            classList.addAll(AsmClassUtils.createClasses());
        }
    }
}
