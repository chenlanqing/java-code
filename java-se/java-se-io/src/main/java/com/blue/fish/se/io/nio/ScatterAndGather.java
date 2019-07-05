package com.blue.fish.se.io.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scatter/Gather：用于描述从 Channel 中读取或者写入到 Channel 的操作，可以读取到多个Buffer中或者通过多个Buffer写出去
 *
 * @author bluefish 2019-07-05
 * @version 1.0.0
 */
public class ScatterAndGather {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress address = new InetSocketAddress(8899);

        serverSocketChannel.socket().bind(address);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long r = socketChannel.read(buffers);
                byteRead += r;

                System.out.println("bytesRead: " + byteRead);

                Arrays.stream(buffers)
                        .map(buffer -> "position: " + buffer.position() + ", limit: " + buffer.limit())
                        .forEach(System.out::println);
            }
            Arrays.asList(buffers).forEach(Buffer::flip);


            long bytesWritten = 0;

            while (bytesWritten < messageLength) {
                long r = socketChannel.write(buffers);
                bytesWritten += r;
            }

            Arrays.asList(buffers).forEach(Buffer::clear);

            System.out.println("bytesRead: " + byteRead + ", byteWritten: " + bytesWritten + ", messageLength: " + messageLength);
        }

    }
}
