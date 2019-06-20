package com.blue.fish.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * @author bluefish 2019-06-20
 * @version 1.0.0
 */
public class ArticleHandler extends ResponsibilityHandler {

    @Override
    public void handle(CourseModel model) {
        if (StringUtils.isNotEmpty(model.getArticle())) {
            System.out.println(model.getName() + " article正常，通过");
            if (handler != null) {
                handler.handle(model);
            }
        } else {
            System.out.println(model.getName() + " article为空，无法通过");
        }
    }
}
