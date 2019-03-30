package com.blue.fish.se.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author bluefish 2019-03-09
 * @version 1.0.0
 */
public class AsyncServerHandler implements Runnable {
    public CountDownLatch latch;

    public AsynchronousServerSocketChannel channel;

    public AsyncServerHandler(int port) {
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(port));
            System.out.println("服务端已启动，端口号:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);

        channel.accept(this, new AcceptHandler());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
