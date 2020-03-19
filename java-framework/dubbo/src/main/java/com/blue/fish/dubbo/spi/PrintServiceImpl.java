package com.blue.fish.dubbo.spi;

/**
 * @author bluefish 2020-03-19
 * @version 1.0.0
 */
public class PrintServiceImpl implements PrintService {
    @Override
    public void print() {
        System.out.println("PrintServiceImpl.......Print");
    }
}
