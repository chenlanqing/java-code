package com.blue.fish.design.pattern.creational.builder;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class Seller {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer assembleComputer(String mainBoard,
                                     String memory,
                                     String cpu,
                                     String hardDisk,
                                     String power){
        computerBuilder.buildMainBoard(mainBoard);
        computerBuilder.buildMemory(memory);
        computerBuilder.buildCpu(cpu);
        computerBuilder.buildHardDisk(hardDisk);
        computerBuilder.buildPower(power);

        return computerBuilder.build();
    }
}
