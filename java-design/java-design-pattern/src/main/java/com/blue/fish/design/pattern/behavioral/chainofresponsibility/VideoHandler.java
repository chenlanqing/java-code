package com.blue.fish.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author bluefish 2019-06-20
 * @version 1.0.0
 */
public class VideoHandler extends ResponsibilityHandler {

    @Override
    public void handle(CourseModel model) {
        if (StringUtils.isNotEmpty(model.getVideo())) {
            System.out.println(model.getName() + " video正常，通过，流程结束");
        } else {
            System.out.println(model.getName() + " video为空，无法通过，流程结束");
        }
    }
}
