package com.blue.fish.se.thread.deadlock;

/**
 * 哲学家就餐问题：发生死锁
 *
 * 如何解决死锁问题：改变一个哲学家的拿筷子顺序
 *
 * @author bluefish 2019-10-03
 * @version 1.0.0
 */
public class DiningPhilosophers {

    private static class Philosopher implements Runnable {

        private final Object leftChopstick;
        private final Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    doAction("Thinking");
                    synchronized (leftChopstick) {
                        doAction("Picked up left chopstick");
                        synchronized (rightChopstick) {
                            doAction("Picked up right chopstick - eating");
                            doAction("Put down right chopstick");
                        }
                        doAction("Put down left chopstick");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " " + action);
            Thread.sleep((long) (Math.random() * 10));
        }
    }

    public static void main(String[] args) {
        // 定义5个哲学家
        Philosopher[] philosophers = new Philosopher[5];
        // 定义5根筷子
        Object[] chopsticks = new Object[philosophers.length];
        // 初始化筷子
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }
        // 启动哲学家线程
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];

            /*
            // 按照统一规则：哲学家都是从左边开始拿筷子，此时会发生死锁
            philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            */

            /* 分界线：上面代码是哲学家就餐发生死锁，下面是哲学家就餐解决死锁问题      */

            /*
             * 解决死锁发生：改变其中一个哲学的拿筷子顺序，其从右边开始拿筷子
             */
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
            } else {
                philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            }

            new Thread(philosophers[i], "哲学家" + (i + 1) + "号").start();
        }
    }
}
