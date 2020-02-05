package com.blue.fish.se.basis.string;

import org.springframework.util.StopWatch;

public class StringBufferTest {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start("string");
        String str = "a" + "b" + "c";
        watch.stop();

        watch.start("strignbuffer");
        StringBuffer sb = new StringBuffer();
        sb.append("a").append("b").append("c");
        String str1 = sb.toString();
        watch.stop();

        System.out.println(watch.prettyPrint());
    }
}