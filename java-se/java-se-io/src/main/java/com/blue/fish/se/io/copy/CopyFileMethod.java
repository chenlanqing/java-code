package com.blue.fish.se.io.copy;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Java文件拷贝的方式
 *
 * @author bluefish 2018/7/29
 * @version 1.0.0
 */
public class CopyFileMethod {

    public static void main(String[] args) throws Exception {
        File source = new File("temp/test1.txt");
        File dest = new File("temp/test2.txt");
//        copyFileByStream(source, dest);
        copyFileByChannel(source,dest);
    }

    /**
     * 使用java流，直接为源文件构建FileInputStream
     *
     * @param source
     * @param dest
     * @throws Exception
     */
    public static void copyFileByStream(File source, File dest) throws Exception {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
        }
    }

    /**
     * 使用java nio 的transferTo 或 transferFrom来实现，其copy速度相对来说更快点，因为其更能利用现代操作系统底层机制，避免不必要的拷贝和上下文切换
     *
     * @param source
     * @param dest
     * @throws Exception
     */
    public static void copyFileByChannel(File source, File dest) throws Exception {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(dest).getChannel()) {
            for (long count = sourceChannel.size(); count
                    > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }
}


