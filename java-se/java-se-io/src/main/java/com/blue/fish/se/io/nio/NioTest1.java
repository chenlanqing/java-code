package com.blue.fish.se.io.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过 MappedByteBuffer 直接操作文件
 *
 * @author bluefish 2019-07-05
 * @version 1.0.0
 */
public class NioTest1 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("temp/niotest1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'a');
        map.put(3, (byte) 'b');

        randomAccessFile.close();
    }
}
