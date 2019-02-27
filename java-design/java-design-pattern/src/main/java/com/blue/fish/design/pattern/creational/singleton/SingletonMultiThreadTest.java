package com.blue.fish.design.pattern.creational.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bluefish 2019-02-27
 * @version 1.0.0
 */
public class SingletonMultiThreadTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new CASThread());
        }

        executorService.shutdown();
    }

    static class CASThread implements Runnable {
        @Override
        public void run() {
            CASSingleton instance = CASSingleton.getInstance();
            System.out.println(instance);
        }
    }
}
