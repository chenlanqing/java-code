package com.blue.fish.se.thread.base;

public class ThreadDump {

    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread1(lock1, lock2).start();
        new Thread2(lock1, lock2).start();
    }

    private static class Thread1 extends Thread {
        Object lock1 = null;
        Object lock2 = null;


        public Thread1(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.setName(getClass().getSimpleName());
        }

        public void run() {
            synchronized (lock1) {
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {

                }
            }
        }
    }

    private static class Thread2 extends Thread {
        Object lock1 = null;
        Object lock2 = null;

        public Thread2(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.setName(getClass().getSimpleName());
        }

        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {

                }
            }
        }
    }
}