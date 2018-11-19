package com.blue.fish.se.thread.producer.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducer {

    public static final String exit_msg = "Good Bye";

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {

        private BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(5L);
                    String msg = "Message_" + i;
                    System.out.println("Produce new item:" + msg);
                    queue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println("Time to say good bye");
                queue.put(exit_msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<String> queue;

        public Consumer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                String msg;
                while (!exit_msg.equalsIgnoreCase(msg = queue.take())){
                    System.out.println("Consumed item: " + msg);
                    Thread.sleep(10L);
                }
                System.out.println("Got exit message, bye!");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
