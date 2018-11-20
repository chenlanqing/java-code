package com.blue.fish.design.pattern.creational.simplefactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class TestSimpleFactory {

    public static void main(String[] args) throws Exception {

        Video video = VideoFactory.getVideo("java");
        video.produce();

        Video video1 = VideoFactory.getVideo(PythonVideo.class);
        video1.produce();

    }
}
