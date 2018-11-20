package com.blue.fish.design.pattern.creational.abstractfactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class PythonCourseFactory implements CourseFactory{
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
