package com.blue.fish.jvm.gc;

/**
 * 长期存活的对象会进入到老年代：主要通过 -XX:MaxTenuringThreshold 参数来控制
 * <p>
 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *
 * @author bluefish 2020-03-18
 * @version 1.0.0
 */
public class LongSurviveObject {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4];
        allocation2 = new byte[_1M * 4];
        allocation3 = new byte[_1M * 4];
        allocation3 = null;
        allocation3 = new byte[_1M * 4];
    }
}
