package com.blue.fish.jvm.direct;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * @author bluefish 2019-02-20
 * @version 1.0.0
 */
public class DirectMemoryAllocate {

    public static void main(String[] args) throws Exception {
//        unsafeAllocate();

        nioAllocate();
    }

    private static void unsafeAllocate() throws Exception{
        // 回报安全异常：SecurityException
//        Unsafe unsafe = Unsafe.getUnsafe();
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        unsafe.allocateMemory(1024);
        unsafe.reallocateMemory(1024, 1024);
        unsafe.freeMemory(1024);
    }

    private static void nioAllocate()throws Exception {
        ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*512);

    }
}
