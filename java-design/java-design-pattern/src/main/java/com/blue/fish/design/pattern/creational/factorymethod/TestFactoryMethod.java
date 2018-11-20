package com.blue.fish.design.pattern.creational.factorymethod;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class TestFactoryMethod {

    public static void main(String[] args) {

        VideoFactory factory = new JavaVideoFactory();
        Video video = factory.getVideo();

        video.produce();
    }
}
