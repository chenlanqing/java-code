package com.blue.fish.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author bluefish 2020-03-19
 * @version 1.0.0
 */
@SPI("defaultImpl")
public interface PrintService {

    void print();
}
