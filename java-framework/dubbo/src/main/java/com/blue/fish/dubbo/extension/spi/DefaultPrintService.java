package com.blue.fish.dubbo.extension.spi;

/**
 * @author bluefish 2020-03-19
 * @version 1.0.0
 */
public class DefaultPrintService implements PrintService {

    @Override
    public void print() {
        System.out.println("DefaultPrintService......默认");
    }
}
