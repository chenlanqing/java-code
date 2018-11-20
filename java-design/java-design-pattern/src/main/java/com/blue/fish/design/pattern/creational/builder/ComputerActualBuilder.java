package com.blue.fish.design.pattern.creational.builder;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class ComputerActualBuilder extends ComputerBuilder {
    Computer computer = new Computer();

    @Override
    public void buildMainBoard(String mainBoard) {
        computer.setMainBoard(mainBoard);
    }

    @Override
    public void buildMemory(String memory) {
        computer.setMemory(memory);
    }

    @Override
    public void buildHardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
    }

    @Override
    public void buildCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void buildPower(String power) {
        computer.setPower(power);
    }

    @Override
    public Computer build() {
        return computer;
    }
}
