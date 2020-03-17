package com.blue.fish.se.basis.common;

import lombok.Data;

import java.util.List;

/**
 * @author bluefish 2020-03-11
 * @version 1.0.0
 */
@Data
public class GradeClass {

    private String className;

    private String gradeName;

    private List<? extends Person> list;

    private List<Student> students;
}
