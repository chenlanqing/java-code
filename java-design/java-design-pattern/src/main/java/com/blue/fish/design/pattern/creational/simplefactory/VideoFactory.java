package com.blue.fish.design.pattern.creational.simplefactory;

/**
 * @author bluefish 2018/11/20
 * @version 1.0.0
 */
public class VideoFactory {

    /**
     * 通过名称判断
     *
     * @param name
     * @return
     */
    public static Video getVideo(String name){
        if ("java".equals(name)) {
            return new JavaVideo();
        } else if ("python".equals(name)) {
            return new PythonVideo();
        }

        return null;
    }

    /**
     * 通过反射实现，添加对应对象时不需要修改该类方法，符合开闭原则
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Video getVideo(Class<?> clazz) throws Exception {
        Video video = (Video) Class.forName(clazz.getName()).newInstance();
        return video;
    }
}
