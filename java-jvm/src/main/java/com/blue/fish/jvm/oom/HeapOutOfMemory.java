package com.blue.fish.jvm.oom;

import com.blue.fish.common.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 模拟堆内存溢出
 * <p>
 * 虚拟机参数：-Xmx32M -Xms32M
 *
 * 导出dump文件：-XX:+HeapDumpOnOutOfMemoryError
 *
 * @author bluefish 2019-06-17
 * @version 1.0.0
 */
public class HeapOutOfMemory {

    private static List<UserInfo> userList = new ArrayList<>();

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            userList.add(new UserInfo(++i, UUID.randomUUID().toString().substring(0, 10)));
        }
    }
}
