package com.blue.fish.se.basis;

import com.blue.fish.se.basis.common.UserModel;

/**
 * @author bluefish 2019-05-31
 * @version 1.0.0
 */
public class StaticInitTime {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(UserModel.time);
        Thread.sleep(1000);
        System.out.println(UserModel.time);
        Thread.sleep(1000);
        System.out.println(UserModel.time);
        Thread.sleep(1000);
        System.out.println(UserModel.time);
        Thread.sleep(1000);
        System.out.println(UserModel.time);
        Thread.sleep(1000);
        System.out.println(UserModel.time);
    }
}
