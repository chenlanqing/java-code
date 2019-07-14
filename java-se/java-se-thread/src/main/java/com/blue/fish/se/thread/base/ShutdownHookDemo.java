package com.blue.fish.se.thread.base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * 钩子函数
 *
 * @author bluefish 2018/8/16
 * @version 1.0.0
 */
public class ShutdownHookDemo {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try(FileWriter fw =  new FileWriter("temp/hook.log")) {
                fw.write("完成销毁工作，回收内存！" + (new Date()).toString());
                System.out.println("退出程序...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        IntStream.range(0,10).forEach(i -> {
            try {
                System.out.println("正在工作...");
                Thread.sleep(2_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
