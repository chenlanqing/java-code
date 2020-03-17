package com.blue.fish.spring.circle;

import com.blue.fish.spring.circle.setter.TestA;
import com.blue.fish.spring.circle.setter.TestB;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring循环依赖问题
 *
 * @author bluefish 2020-03-17
 * @version 1.0.0
 */
public class SpringCircleReference {

    public static void main(String[] args) {
        SpringCircleReference s = new SpringCircleReference();

        // 测试：构造器循环依赖
//        s.testConstructor();


        s.testSetter();


    }

    /**
     * setter循环依赖
     */
    public void testSetter(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/circle-setter.xml");
        TestA bean = context.getBean(TestA.class);
        System.out.println(bean.getTestB());
        System.out.println(context.getBean(TestB.class));
    }
    /**
     * 构造器循环依赖
     */
    public void testConstructor(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/circle-constructor.xml");
    }
}
