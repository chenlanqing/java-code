package com.blue.fish.demo;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] nexts = next.split(" ");
        int M = Integer.valueOf(nexts[0]);
        int N = Integer.valueOf(nexts[1]);

        float[][] array = new float[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            for (int j = 0; j < lines.length; j++) {
                array[i][j] = Float.valueOf(lines[j]);
            }
        }
        BigDecimal sum = new BigDecimal("0.0");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    sum = sum.add(BigDecimal.valueOf(array[i][j]));
                } else {
                    if (j == 0) {
                        if (array[i][j] > array[i - 1][j]){
                            sum = sum.add(BigDecimal.valueOf(array[i][j]));
                        }
                    } else {
                        if (array[i][j] > array[i - 1][j] && array[i][j] > array[i][j - 1]) {
                            sum = sum.add(BigDecimal.valueOf(array[i][j]));
                        }
                    }

                }
            }
        }
        System.out.println(String.format("%06f", sum.floatValue()));
    }
}
