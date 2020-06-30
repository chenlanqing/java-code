package com.blue.fish.design.pattern.creational.singleton;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author QingFan 2020-06-29
 * @version 1.0.0
 */
public class TestCasStampSingleton {
    static Set<CASStampSingleton> set = new CopyOnWriteArraySet<>();
    static Set<CASSingleton> re = new CopyOnWriteArraySet<>();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new TestStampReference()).start();
        }
        System.out.println(set);


        for (int i = 0; i < 100; i++) {
            new Thread(new TestReference()).start();
        }
        System.out.println(re);
    }

    static class TestStampReference implements Runnable {
        @Override
        public void run() {
            set.add(CASStampSingleton.getInstance());
        }
    }

    static class TestReference implements Runnable {
        @Override
        public void run() {
            re.add(CASSingleton.getInstance());
        }
    }
}
