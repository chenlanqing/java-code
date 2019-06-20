package com.blue.fish.design.pattern.behavioral.chainofresponsibility;

/**
 * @author bluefish 2019-06-20
 * @version 1.0.0
 */
public abstract class ResponsibilityHandler {

    protected ResponsibilityHandler handler;

    protected void setHandler(ResponsibilityHandler handler) {
        this.handler = handler;
    }


    public abstract void handle(CourseModel model);

}
