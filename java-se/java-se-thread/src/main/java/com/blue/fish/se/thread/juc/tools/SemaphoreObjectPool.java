package com.blue.fish.se.thread.juc.tools;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author bluefish 2019-05-25
 * @version 1.0.0
 */
public class SemaphoreObjectPool<T, R> {

    private final List<T> pool;
    private final Semaphore sem;

    public SemaphoreObjectPool(int size, T t) {
        pool = new Vector<>(size);
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }

        sem = new Semaphore(size);
    }

    R exec(Function<T, R> func){
        T t= null;
        try {
            sem.acquire();
            t = pool.remove(0);
            return func.apply(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            pool.add(t);
            sem.release();
        }
    }
}
