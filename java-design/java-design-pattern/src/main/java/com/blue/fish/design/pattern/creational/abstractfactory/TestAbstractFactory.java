package com.blue.fish.design.pattern.creational.abstractfactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();

        video.produce();
        article.produce();
    }
}
