package com.blue.fish.design.pattern.creational.builder;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public abstract class ComputerBuilder {

    public abstract void buildMainBoard(String mainBoard);
    public abstract void buildMemory(String memory);
    public abstract void buildHardDisk(String hardDisk);
    public abstract void buildCpu(String cpu);
    public abstract void buildPower(String power);

    public abstract Computer build();

}
