package com.blue.fish.se.basis.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author bluefish 2019-07-09
 * @version 1.0.0
 */
public class JDK8DateFormat {

    public static void main(String[] a){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(formatter.format(localDateTime));

        String str = "2019年06月23日 23:59:59";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse(str,formatter2);
        System.out.println(localDateTime2);

    }
}
