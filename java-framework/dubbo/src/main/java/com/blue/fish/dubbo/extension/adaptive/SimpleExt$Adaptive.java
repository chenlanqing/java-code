//package com.blue.fish.dubbo.adaptive;
//
//import org.apache.dubbo.common.extension.ExtensionLoader;
//
//public class SimpleExt$Adaptive implements SimpleExt {
//    public java.lang.String echo(org.apache.dubbo.common.URL arg0, java.lang.String arg1) {
//        if (arg0 == null) throw new IllegalArgumentException("url == null");
//        org.apache.dubbo.common.URL url = arg0;
//        /**
//         * 如果 @Adaptive 注解没有传入key的值，则默认会把类名转换为key，比如：SimpleExt 会转换成 simple.ext
//         *
//         * 根据key获取对应扩展点实现名称，第一个参数是key，第二个是获取不到时默认值
//         *
//         * URL中没有“simple.ext”这个key，因此extName 取值为 simpleImpl，
//         *
//         * 如果 @Adaptive 注解中有key参数，如果 @Adaptive("second")，则会变成 url.getParameter("second", "simpleImpl");
//         */
//        String extName = url.getParameter("second", "simpleImpl");
//        if (extName == null)
//            throw new IllegalStateException("Failed to get extension (SimpleExt) name from url (" + url.toString() + ") use keys([second])");
//        SimpleExt extension = (SimpleExt) ExtensionLoader.getExtensionLoader(SimpleExt.class).getExtension(extName);
//        return extension.echo(arg0, arg1);
//    }
//}