package com.blue.fish.se.collection;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.ArrayList;

/**
 * @author bluefish 2020-01-16
 * @version 1.0.0
 */
public class TestPerformance {

    @Test
    public void testBatchAddPerformance(){
        // 准备拷贝数据
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<3000000;i++){
            list.add(i);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("单个 for 循环新增 300 w 个");
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list2.add(list.get(i));
        }
        stopWatch.stop();

        // 批量新增
        stopWatch.start("批量新增 300 w 个");
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.addAll(list);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}
