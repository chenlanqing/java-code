package com.blue.fish.se.basis.binary;

/**
 * @author bluefish 2020-02-29
 * @version 1.0.0
 */
public class OddEvenNumberJudge {

    public static void main(String[] args) {
        judge(12345);

        judge(1234);
    }

    private static void judge(int number) {
        System.out.println(Integer.toBinaryString(number) + ":" + ((number & 1) == 0 ? "是偶数" : "是奇数"));
    }
}
