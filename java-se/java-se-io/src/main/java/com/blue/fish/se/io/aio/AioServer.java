package com.blue.fish.se.io.aio;

/**
 * 参考代码
 *
 * @author bluefish 2019-03-09
 * @version 1.0.0
 */
public class AioServer {

    private static int DEFAULT_PORT = 12345;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        start();
    }
}
