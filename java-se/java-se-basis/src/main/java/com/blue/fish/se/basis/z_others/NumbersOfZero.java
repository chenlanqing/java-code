package com.blue.fish.se.basis.z_others;

import java.util.Scanner;

/**
 * 给定一个正整数，不能将其转换为字符串，判断有多少个0
 *
 * @author QingFan 2020-07-03
 * @version 1.0.0
 */
public class NumbersOfZero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int i = scanner.nextInt();
            int count = 0;

            while (i >= 10) {
                if (i % 10 == 0) {
                    count++;
                }
                i = i / 10;
            }

            System.out.println(count);
        }
    }
}
