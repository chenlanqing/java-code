package com.blue.fish.spring.ioc;

import com.blue.fish.spring.entity.Person;
import com.blue.fish.spring.entity.Student;
import com.blue.fish.spring.util.SpringRegisterBeanUtil;

/**
 * @author bluefish 2019-07-24
 * @version 1.0.0
 */
public class SelfRegisterBean {

    public static void main(String[] args) {
        Student student = new Student();
        student.setGrade("高一");
        student.setCla("三班");
        student.setNum("20171320");

        SpringRegisterBeanUtil.registerBean("student", student);

        Student s = SpringRegisterBeanUtil.getBean("student");
        System.out.println(s);

        System.out.println((Person)SpringRegisterBeanUtil.getBean("person"));
    }
}
