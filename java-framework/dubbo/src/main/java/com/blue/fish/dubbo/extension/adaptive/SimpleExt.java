package com.blue.fish.dubbo.extension.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author bluefish 2020-03-20
 * @version 1.0.0
 */
@SPI
public interface SimpleExt {

//    @Adaptive("second")
    String echo(URL url, String s);
}
