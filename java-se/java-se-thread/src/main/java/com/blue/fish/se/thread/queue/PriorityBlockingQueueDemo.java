package com.blue.fish.se.thread.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author bluefish 2020-04-01
 * @version 1.0.0
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<Student> queue = new PriorityBlockingQueue<>(10);
        queue.add(new Student("bb",2));
        queue.add(new Student("aa",1));


        System.out.println(queue);
    }


    static class Student implements Comparable<Student>{
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            return name.compareTo(o.name);
        }
    }
}
