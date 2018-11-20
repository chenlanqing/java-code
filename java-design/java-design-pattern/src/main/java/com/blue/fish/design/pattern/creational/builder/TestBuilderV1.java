package com.blue.fish.design.pattern.creational.builder;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class TestBuilderV1 {

    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerActualBuilder();
        Seller seller = new Seller();
        seller.setComputerBuilder(computerBuilder);

        Computer build = seller.assembleComputer("七彩虹",
                "金士顿", "Intel", "West Data", "金田");
        System.out.println(build);

    }
}
