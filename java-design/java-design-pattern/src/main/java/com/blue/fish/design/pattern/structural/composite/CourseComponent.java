package com.blue.fish.design.pattern.structural.composite;

/**
 * @author bluefish 2018/11/27
 * @version 1.0.0
 */
public class CourseComponent extends Component{
    private String name;

    public CourseComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName(Component component) {
        return this.name;
    }
}
