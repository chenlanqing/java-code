package com.blue.fish.se.thread.base;

/**
 * @author bluefish 2019-09-02
 * @version 1.0.0
 */
public class BothThreadRunnable {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable ......");
            }
        }){
            public void run(){
                System.out.println("Thread ......");
            }
        }.start();
    }
}
