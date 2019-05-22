package com.blue.fish.se.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

/**
 * @author bluefish 2019-05-14
 * @version 1.0.0
 */
public class AioFileReadWrite {

    public static void main(String[] args) throws Exception {
        Path file = Paths.get("temp/test.txt");

        AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

        ByteBuffer buffer = ByteBuffer.allocate(100_000);

        Future<Integer> result = channel.read(buffer, 0);

        while (!result.isDone()) {
            ProfileCalculator.calculateTax();
        }

        Integer bytesRead = result.get();

        System.out.println("Bytes read[" + bytesRead + "]");
    }

    static class ProfileCalculator {
        public ProfileCalculator() {
        }

        public static void calculateTax() {
        }
    }
}
