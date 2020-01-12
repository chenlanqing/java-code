package com.blue.fish.se.thread.lock.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author bluefish 2020-01-08
 * @version 1.0.0
 */
public class ReadWriteNonFairBarge {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void read() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到读锁，正在读取");
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "是否读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(ReadWriteNonFairBarge::write, "Thead1").start();
        new Thread(ReadWriteNonFairBarge::read, "Thead2").start();
        new Thread(ReadWriteNonFairBarge::read, "Thead3").start();
        new Thread(ReadWriteNonFairBarge::write, "Thead4").start();
        new Thread(ReadWriteNonFairBarge::read, "Thead5").start();

        new Thread(() -> {
            Thread[] ts = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                ts[i] = new Thread(ReadWriteNonFairBarge::read, "子线程创建的thread" + i);
            }
            for (int i = 0; i < 1000; i++) {
                ts[i].start();
            }
        }).start();
    }
}
