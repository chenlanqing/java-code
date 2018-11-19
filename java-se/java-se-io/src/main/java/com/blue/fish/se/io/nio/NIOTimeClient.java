package com.blue.fish.se.io.nio;

/**
 * @author bluefish 2018/6/9
 * @version 1.0.0
 */
public class NIOTimeClient {
    public static void main(String[] args) {
        new Thread(new NIOTimeClientHandler("127.0.0.1", 8000), "TimeClient-001").start();
    }
}
