package com.blue.fish.se.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * LongAdder比AtomicLong性能好
 *
 * @author bluefish 2019-12-31
 * @version 1.0.0
 */
public class AtomicLongDemo {

    public static void main(String[] args) throws Exception{
        AtomicLong counter = new AtomicLong(0);

        ExecutorService service = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            service.submit(new Task(counter));
        }
        service.shutdown();

        while (!service.isTerminated()) {

        }

        System.out.println(counter.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    static class Task implements Runnable {

        private AtomicLong counter;

        public Task(AtomicLong counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        }
    }
}
