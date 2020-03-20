package com.blue.fish.dubbo.extension.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author bluefish 2020-03-20
 * @version 1.0.0
 */
public class AdaptiveDemoTest {

    public static void main(String[] args) {
        ExtensionLoader<SimpleExt> loader = ExtensionLoader.getExtensionLoader(SimpleExt.class);
        SimpleExt simpleExt = loader.getAdaptiveExtension();

        URL url = URL.valueOf("dubbo://127.0.0.1:1010/path?second=second");

        simpleExt.echo(url, "sssss");
    }
}
