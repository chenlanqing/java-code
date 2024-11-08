package com.qing.fan.producer.consumer.exchanger;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:55
 */
public class ExchangerMain {

    public static void main(String[] args) {
        List<String> producer = new ArrayList<>();
        List<String> consumer = new ArrayList<>();
        Exchanger<List<String>> exchanger = new Exchanger<>();

        new Thread(new Producer(producer, exchanger), "生产者").start();
        new Thread(new Consumer(consumer, exchanger), "消费者").start();
    }

    private static class Producer implements Runnable {

        private final List<String> buffer;
        private final Exchanger<List<String>> exchanger;

        public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("生产者第" + i + "次提供");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("生产者装入" + i + "--" + j);
                    buffer.add("buffer：" + i + "--" + j);
                }
                System.out.println("生产者装满，等待与消费者交换...");
                try {
                    exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private List<String> buffer;
        private final Exchanger<List<String>> exchanger;

        public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
            this.buffer = buffer;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                //调用exchange()与消费者进行数据交换
                try {
                    buffer = exchanger.exchange(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者第" + i + "次提取");
                for (int j = 1; j <= 3; j++) {
                    System.out.println("消费者 : " + buffer.get(0));
                    buffer.remove(0);
                }
            }
        }
    }

}
