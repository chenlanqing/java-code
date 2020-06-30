//package com.blue.fish.design.pattern.creational.prototype.deepclone;
//
//import com.blue.fish.common.util.DateUtil;
//
///**
// * @author bluefish 2018/11/24
// * @version 1.0.0
// */
//public class TestDeepClone {
//
//    public static void main(String[] args) throws Exception {
//        People p = new People();
//        p.setName("张三丰");
//        p.setBirthday(DateUtil.parseToDate("1875-11-11 11:11:11"));
//
//        People p2 = (People) p.clone();
//
//        System.out.println(p);
//        System.out.println(p2);
//
//        System.out.println("~~~~~~~~~~~~~~~~");
//
//        p.getBirthday().setTime(66666666666L);
//        System.out.println(p);
//        System.out.println(p2);
//    }
//}
