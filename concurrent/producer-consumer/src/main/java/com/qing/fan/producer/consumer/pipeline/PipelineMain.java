package com.qing.fan.producer.consumer.pipeline;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月08日 21:49
 */
public class PipelineMain {

    private static final PipedInputStream pis = new PipedInputStream();

    private static final PipedOutputStream pos = new PipedOutputStream();

    static {
        try {
            pis.connect(pos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer(), "生产者").start();
        new Thread(new Consumer(), "消费者").start();
    }

    private static class Producer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    int num = (int) (Math.random() * 255);
                    System.out.println(Thread.currentThread().getName() + "生产者生产了一个数字，该数字为： " + num);
                    pos.write(num);
                    pos.flush();
                }
            } finally {
                pis.close();
                pos.close();
            }
        }
    }

    private static class Consumer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                    int num = pis.read();
                    System.err.println(Thread.currentThread().getName() + " 消费者消费了一个数字，该数字为： " + num);
                }
            } finally {
                pis.close();
                pos.close();
            }
        }
    }
}
