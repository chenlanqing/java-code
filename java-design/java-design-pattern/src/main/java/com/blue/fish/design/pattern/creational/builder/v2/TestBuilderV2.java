package com.blue.fish.design.pattern.creational.builder.v2;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class TestBuilderV2 {

    public static void main(String[] args) {

        Computer computer = new Computer.ComputerBuilder()
                .buildMainBoard("七彩虹")
                .buildCpu("因特尔")
                .buildHardDisk("希捷")
                .buildMemory("金士顿")
                .buildPower("金田")
                .assembleComputer();

        System.out.println(computer);
    }
}
