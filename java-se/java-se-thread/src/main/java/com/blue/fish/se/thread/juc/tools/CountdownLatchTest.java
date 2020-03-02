package com.blue.fish.se.thread.juc.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 并发测试：模拟并发请求
 *
 * @author bluefish 2019-03-12
 * @version 1.0.0
 */
public class CountdownLatchTest {

    public static void main(String[] args) throws Exception {
        final int threadNum = 5;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            final int j = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("等待闸门释放：" + j);
                    // 等待所有资源准备就绪，startGate表示所有请求都在这里等待
                    startGate.await();
                    // 外部调用 startGate的countDown方法之后，所有的请求开始处理数据
                    System.out.println("闸门释放：" + j);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            });
            thread.start();
        }
        startGate.countDown();
        end.await();

    }
}
