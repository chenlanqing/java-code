package com.blue.fish.se.basis;

/**
 * 二进制数据测试-取模与& 运算
 *
 * @author bluefish 2018/4/26
 * @version 1.0.0
 */
public class BinaryExample1 {
    public static void main(String[] args) {
        System.out.println(1 << 3);
        System.out.println(10 % (1 << 3));
        System.out.println(10 & ( (1<< 3) - 1));
    }
}
