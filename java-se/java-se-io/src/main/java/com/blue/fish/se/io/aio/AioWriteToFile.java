package com.blue.fish.se.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author bluefish 2019-05-14
 * @version 1.0.0
 */
public class AioWriteToFile {

    public static void main(String[] args) throws Exception {
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("temp/aio.txt"),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println("Attachment:" + attachment + " " + result + " bytes written");
                System.out.println("CompletionHandler Thread Id:" + Thread.currentThread().getId());
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("Attachment:" + attachment + " failed with:");
                exc.printStackTrace();
            }
        };

        System.out.println("Main thread Id:" + Thread.currentThread().getId());

        fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write", handler);
        fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0, "Second Write", handler);
    }
}
