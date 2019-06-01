package com.blue.fish.jvm.gc;

import java.util.ArrayList;

/**
 * 模拟高CPU占用
 *
 * @author bluefish 2019-05-30
 * @version 1.0.0
 */
public class HighCpuOccupation {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;

        while (true) {
            ++i;
            list.add("Hello" + i);

            if (list.size() == 1000000) {
                Thread.sleep(2000);
            }
        }
    }
}
