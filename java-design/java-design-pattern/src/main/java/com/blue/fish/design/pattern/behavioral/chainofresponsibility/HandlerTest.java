package com.blue.fish.design.pattern.behavioral.chainofresponsibility;

/**
 * @author bluefish 2019-06-20
 * @version 1.0.0
 */
public class HandlerTest {

    public static void main(String[] args) {
        ResponsibilityHandler article = new ArticleHandler();

        ResponsibilityHandler video = new VideoHandler();

        article.setHandler(video);

        CourseModel model = new CourseModel();
        model.setName("Java设计模式");
        model.setArticle("Java设计模式---文章地址");
        model.setVideo("Java设计模式---视频地址");

        article.handle(model);
    }
}
