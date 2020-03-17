package com.blue.fish.jvm.classloader;

/**
 * @author bluefish 2020-03-12
 * @version 1.0.0
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while(loader != null){
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }
}
