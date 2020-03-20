package com.blue.fish.dubbo.extension.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author bluefish 2020-03-20
 * @version 1.0.0
 */
@Adaptive
public class SecondSimpleExt implements SimpleExt {
    @Override
    public String echo(URL url, String s) {
        System.out.println("Second........");
        return s;
    }
}
