package com.qing.fan.basic.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月14日 21:19
 */
public class DateDemo {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear());
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.YEAR));
    }
}
