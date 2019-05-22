package com.blue.fish.se.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author bluefish 2019-05-14
 * @version 1.0.0
 */
public class NioFileReadWrite {

    public static void main(String[] args) {
        readNio();

        writerNio();
    }

    public static void readNio() {
        String pathName = "temp/test.txt";
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(new File(pathName));

            FileChannel channel = fin.getChannel();

            int capacity = 100;
            ByteBuffer bf = ByteBuffer.allocate(capacity);

            System.out.println("限制：" + bf.limit() + "，容量是：" + bf.capacity() + "，位置是：" + bf.position());

            int length = -1;
            while ((length = channel.read(bf)) != -1) {
                bf.clear();

                byte[] bytes = bf.array();

                System.out.write(bytes, 0, length);

                System.out.println();

                System.out.println("限制：" + bf.limit() + "，容量是：" + bf.capacity() + "，位置是：" + bf.position());
            }

            channel.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void writerNio() {
        String fileName = "temp/nio.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(new File(fileName));

            FileChannel channel = fos.getChannel();

            ByteBuffer src = Charset.forName("utf8").encode("Hello NIO");

            System.out.println("初始化容量和limit：" + src.capacity() + "，" + src.limit());

            int length = 0;

            while ((length = channel.write(src)) != 0) {
                System.out.println("写入长度:" + length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
