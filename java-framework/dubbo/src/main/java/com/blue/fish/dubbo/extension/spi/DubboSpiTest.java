package com.blue.fish.dubbo.extension.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author bluefish 2020-03-19
 * @version 1.0.0
 */
public class DubboSpiTest {

    public static void main(String[] args) {
        ExtensionLoader<PrintService> loader = ExtensionLoader.getExtensionLoader(PrintService.class);

//        PrintService defaultExtension = loader.getDefaultExtension();

        PrintService defaultExtension = loader.getExtension("true");

        defaultExtension.print();
    }
}
