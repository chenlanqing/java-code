package com.blue.fish.dubbo.extension.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @author bluefish 2020-03-20
 * @version 1.0.0
 */
public class SimpleExtImpl implements SimpleExt {
    @Override
    public String echo(URL url, String s) {
        System.out.println(url.getParameters());
        System.out.println(s);
        return s;
    }
}
