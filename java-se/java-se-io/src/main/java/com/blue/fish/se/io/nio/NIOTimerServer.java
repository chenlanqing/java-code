package com.blue.fish.se.io.nio;

/**
 * @author bluefish 2018/6/9
 * @version 1.0.0
 */
public class NIOTimerServer {
    private static final int port = 8000;

    public static void main(String[] args) {
        MultiplexerTimeServer timeServer  = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
