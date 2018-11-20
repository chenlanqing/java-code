package com.blue.fish.design.pattern.creational.builder.v2;

import lombok.Data;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
@Data
public class Computer {

    private String mainBoard;
    private String memory;
    private String hardDisk;
    private String cpu;
    private String power;

    public Computer(ComputerBuilder computerBuilder) {
        this.mainBoard = computerBuilder.mainBoard;
        this.memory = computerBuilder.memory;
        this.hardDisk = computerBuilder.hardDisk;
        this.cpu = computerBuilder.cpu;
        this.power = computerBuilder.power;
    }

    public static class ComputerBuilder{
        private String mainBoard;
        private String memory;
        private String hardDisk;
        private String cpu;
        private String power;

        public ComputerBuilder buildMainBoard(String mainBoard){
            this.mainBoard = mainBoard;
            return this;
        }
        public ComputerBuilder buildMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public ComputerBuilder buildHardDisk(String hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public ComputerBuilder buildCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder buildPower(String power) {
            this.power = power;
            return this;
        }

        public Computer assembleComputer(){
            return new Computer(this);
        }
    }
}
