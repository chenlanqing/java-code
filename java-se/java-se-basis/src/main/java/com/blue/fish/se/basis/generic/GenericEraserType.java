package com.blue.fish.se.basis.generic;

import com.blue.fish.se.basis.common.GradeClass;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
public class GenericEraserType {

    public static void main(String[] args) throws Exception{
        GradeClass grade = new GradeClass();
        grade.setGradeName("三年级");
        grade.setClassName("二班");
        grade.setList(new ArrayList<>());
        grade.setStudents(new ArrayList<>());


        Class<? extends GradeClass> clazz = grade.getClass();

        Field list = clazz.getDeclaredField("list");
        list.setAccessible(true);

        ParameterizedType genericType = (ParameterizedType) list.getGenericType();
        System.out.println(genericType.getActualTypeArguments()[0]);
    }
}
