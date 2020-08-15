package com.blue.fish.design.pattern.structural.proxy.dynamicproxy;

import com.blue.fish.design.pattern.structural.proxy.IOrderService;
import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.OrderServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class TestDynamicProxy {
    public static void main(String[] args) throws Exception {
        Order order = new Order();
        order.setUserId(2);

        IOrderService proxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        proxy.saveOrder(order);


        String proxyName = "com.blue.fish.design.pattern.structural.proxy.dynamicproxy.$Proxy0";
        Class[] interfaces = new Class[]{IOrderService.class};
        int accessFlags = Modifier.PUBLIC;
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                proxyName, interfaces, accessFlags);
        // 将字节数组写出到磁盘
        File file = new File("java-design/java-design-pattern/$Proxy0.class");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(proxyClassFile);


        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ClassLoader classLoader = TestDynamicProxy.class.getClassLoader();
        Class[] classes = new Class[]{IOrderService.class};
        Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxy, args);
            }
        });
    }
}
