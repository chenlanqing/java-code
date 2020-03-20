package com.blue.fish.dubbo.extension.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author bluefish 2020-03-19
 * @version 1.0.0
 */
public class JavaSpiTest {

    public static void main(String[] args) {
        ServiceLoader<PrintService> loader = ServiceLoader.load(PrintService.class);

        Iterator<PrintService> iterator = loader.iterator();

        while (iterator.hasNext()) {
            PrintService next = iterator.next();
            next.print();
        }
    }
}
