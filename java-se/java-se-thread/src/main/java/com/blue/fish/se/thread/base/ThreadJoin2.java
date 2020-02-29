package com.blue.fish.se.thread.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2020-02-08
 * @version 1.0.0
 */
@Slf4j
public class ThreadJoin2 {

    public static void main(String[] args) throws Exception{
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("我是子线程 2,开始沉睡");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("我是子线程 2，执行完成");
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("我是子线程 1，开始运行");
                try {
                    log.info("我是子线程 1，我在等待子线程 2");
                    // 这里是代码关键
                    thread2.join();
                    log.info("我是子线程 1，子线程 2 执行完成，我继续执行");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("我是子线程 1，执行完成");
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(100000);
    }
}
