package com.blue.fish.jvm.oom;

/**
 * 虚拟机栈内存溢出或者内存泄漏，栈内容容量太小
 * <p>
 * VM Options : -Xss128k   该参数等同于:  -XX:ThreadStackSize
 *
 * @author bluefish 2020-03-07
 * @version 1.0.0
 */
public class VmStackOutOfMemoryStackCapacity {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        VmStackOutOfMemoryStackCapacity oom = new VmStackOutOfMemoryStackCapacity();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length：" + oom.stackLength);
            throw e;
        }
    }
}
