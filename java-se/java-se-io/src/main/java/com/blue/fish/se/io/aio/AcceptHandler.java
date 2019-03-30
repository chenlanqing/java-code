package com.blue.fish.se.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author bluefish 2019-03-09
 * @version 1.0.0
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncServerHandler serverHandler) {
        AioServer.clientCount++;

        System.out.println("连接的客户端数：" + AioServer.clientCount);

        serverHandler.channel.accept(serverHandler, this);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer, buffer, new ReadHandler(channel));

    }

    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
