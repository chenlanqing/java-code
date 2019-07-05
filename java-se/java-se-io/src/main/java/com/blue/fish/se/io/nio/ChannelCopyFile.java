package com.blue.fish.se.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过通道来拷贝文件
 *
 * @author bluefish 2019-07-05
 * @version 1.0.0
 */
public class ChannelCopyFile {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.txt");
        FileOutputStream out = new FileOutputStream("temp/test1-copy.txt");

        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int read = inChannel.read(buffer);

        if (read == -1) {
            return;
        }

        buffer.flip();

        outChannel.write(buffer);

        in.close();
        in.close();
    }
}
