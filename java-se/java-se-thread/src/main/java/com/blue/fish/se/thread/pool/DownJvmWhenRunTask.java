package com.blue.fish.se.thread.pool;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bluefish 2020-03-13
 * @version 1.0.0
 */
public class DownJvmWhenRunTask {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(() -> {
            try {
                File file = new File("temp/pool.txt");
                FileOutputStream outputStream = new FileOutputStream(file);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                for (int i = 0; i < 1000; i++) {
                    writer.write(i + "\n");
                    Thread.sleep(10);
                }
                System.out.println("文件已经写完.....");
                writer.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();
    }
}
