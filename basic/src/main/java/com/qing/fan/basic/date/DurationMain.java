package com.qing.fan.basic.date;

import java.time.Duration;

/**
 * @author QingFan
 * @version 1.0.0
 * @date 2024年11月14日 21:29
 */
public class DurationMain {

    public static void main(String[] args) {
        Duration duration = Duration.parse("P2DT3H4M");
        System.out.println(duration.toDays());

    }
}
