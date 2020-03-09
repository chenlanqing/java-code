package com.blue.fish.jvm.oom;

/**
 * 虚拟机栈内存溢出或者内存泄漏：创建大量线程
 * <p>
 * VM Options : -Xss2M
 *
 * @author bluefish 2020-03-07
 * @version 1.0.0
 */
public class VmStackOutOfMemoryManyThread {

    public void test() {
        while (true) {
        }
    }

    public void thread() {
        while (true) {
            new Thread(this::test).start();
        }
    }

    public static void main(String[] args) {
        VmStackOutOfMemoryManyThread t = new VmStackOutOfMemoryManyThread();
        t.thread();
    }
}
