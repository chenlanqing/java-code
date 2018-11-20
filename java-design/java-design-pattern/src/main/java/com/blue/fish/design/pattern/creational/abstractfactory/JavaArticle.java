package com.blue.fish.design.pattern.creational.abstractfactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class JavaArticle extends Article{
    @Override
    public void produce() {
        System.out.println("编写Java文章");
    }
}
