package com.blue.fish.se.basis.binary;

/**
 * 二进制运算：&
 *
 * @author bluefish 2020-02-29
 * @version 1.0.0
 */
public class BinaryOperatorWith {

    public static void main(String[] args) {
        System.out.println(toZero(1234));
        System.out.println(Integer.toBinaryString(255));
        System.out.println(Integer.toHexString(255));
    }

    private static int find(int number){
        // 取一个数中指定位置，如：x = 10101110， 取 x 的低四位，用 `x & 00001111 = 00001110`，即可得到

        return 0;
    }

    private static int toZero(int number) {
        return number & 0;
    }
}
