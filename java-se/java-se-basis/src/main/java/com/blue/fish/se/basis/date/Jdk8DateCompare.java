package com.blue.fish.se.basis.date;

import java.time.LocalDate;

/**
 * @author bluefish 2020-04-23
 * @version 1.0.0
 */
public class Jdk8DateCompare {

    public static void main(String[] args) {
        LocalDate start = LocalDate.parse("2020-04-21");
        LocalDate end = LocalDate.parse("2020-04-29");
        System.out.println(LocalDate.now().isAfter(start));
        System.out.println(LocalDate.now().isBefore(end));

    }
}
