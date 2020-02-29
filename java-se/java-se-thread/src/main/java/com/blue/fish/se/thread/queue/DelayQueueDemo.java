package com.blue.fish.se.thread.queue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DelayQueueDemo {
    // 队列消息的生产者
    static class Product implements Runnable {
        private final DelayQueue<DelayedDTO> queue;

        public Product(DelayQueue<DelayedDTO> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            log.info("begin put");
            long beginTime = System.currentTimeMillis();
            queue.put(new DelayedDTO(System.currentTimeMillis() + 2000L, beginTime));//延迟 2 秒执行
            queue.put(new DelayedDTO(System.currentTimeMillis() + 5000L, beginTime));//延迟 5 秒执行
            queue.put(new DelayedDTO(System.currentTimeMillis() + 1000L * 10, beginTime));//延迟 10 秒执行
            log.info("end put");
        }
    }

    // 队列的消费者
    static class Consumer implements Runnable {
        private final DelayQueue<DelayedDTO> queue;

        public Consumer(DelayQueue<DelayedDTO> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                log.info("Consumer begin");
                (queue.take()).run();
                (queue.take()).run();
                (queue.take()).run();
                log.info("Consumer end");
            } catch (InterruptedException e) {
                log.error("" + e);
            }
        }
    }

    @Data
    // 队列元素，实现了 Delayed 接口
    static class DelayedDTO implements Delayed {
        Long s;
        Long beginTime;

        public DelayedDTO(Long s, Long beginTime) {
            this.s = s;
            this.beginTime = beginTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(s - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }

        public void run() {
            log.info("现在已经过了{}秒钟", (System.currentTimeMillis() - beginTime) / 1000);
        }
    }

    // demo 运行入口
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedDTO> q = new DelayQueue<>();
        DelayQueueDemo.Product p = new DelayQueueDemo.Product(q);
        DelayQueueDemo.Consumer c = new DelayQueueDemo.Consumer(q);
        new Thread(c).start();
        new Thread(p).start();
    }
}