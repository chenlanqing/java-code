package com.blue.fish.design.pattern.creational.abstractfactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
