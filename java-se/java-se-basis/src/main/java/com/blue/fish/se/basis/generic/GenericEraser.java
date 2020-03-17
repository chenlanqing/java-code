package com.blue.fish.se.basis.generic;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦除
 *
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class GenericEraser {
    public static void main(String[] args) throws Exception {
        ParameterizedType type = (ParameterizedType) Bar.class.getGenericSuperclass();
        System.out.println(type.getActualTypeArguments()[0]);

        ParameterizedType fieldType = (ParameterizedType) Foo.class.getField("children").getGenericType();
        System.out.println(fieldType.getActualTypeArguments()[0]);

        ParameterizedType paramType = (ParameterizedType) Foo.class.getMethod("foo", List.class).getGenericParameterTypes()[0];
        System.out.println(paramType.getActualTypeArguments()[0]);

        System.out.println(Foo.class.getTypeParameters()[0].getBounds()[0]);
    }

    static class Foo<E extends CharSequence> {
        public List<Bar> children = new ArrayList<Bar>();

        public List<StringBuilder> foo(List<String> foo) {
            return null;
        }

        public void bar(List<? extends String> param) {
        }
    }

    static class Bar extends Foo<String> {
    }

}
