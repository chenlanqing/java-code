package com.blue.fish.se.basis.generic;


import java.util.LinkedList;
import java.util.List;

public class DemoGenerice {
    public static void main(String[] args) {
        List<? extends Season> list = new LinkedList<>();
//        list.add(new Season()); //  编译错误
    }

    public <T extends Season> T addAll(List<T> c){

        return c.get(0);
    }

    static class Season {
    }

    static class Spring extends Season {
    }

//    public static <T> T get(T t1, T t2){
//        // 编译失败
//        if (t1.compareTo(t2) >= 0);
//        return t1;
//    }
    // 编译成功.因为限定类型为 Comparable 接口，其存在 compareTo 方法，所以 t1、t2 擦除后被强转成功
    // 所以类型限定在泛型类、泛型接口和泛型方法中都可以使用
    public static <T extends Comparable> T get(T t1,T t2){
        if (t1.compareTo(t2)>=0);
        return t1;
    }

}
