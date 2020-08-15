package com.blue.fish.design.pattern.structural.proxy.jdkdynamicproxy;

import com.blue.fish.design.pattern.structural.proxy.IOrderService;
import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class OrderServiceProxy {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名，默认是生成到当前目录下的  com/sun/proxy/$Proxy0.class
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 1. 创建被代理的对象，IOrderService接口的实现类
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        // 2. 获取对应的 ClassLoader
        ClassLoader classLoader = orderServiceImpl.getClass().getClassLoader();
        // 3. 获取所有接口的Class，这里的OrderServiceImpl只实现了一个接口IOrderService，
        Class[] interfaces = orderServiceImpl.getClass().getInterfaces();
        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //    这里创建的是一个自定义的日志处理器，须传入实际的执行对象 userServiceImpl
        InvocationHandler logHandler = new LogHandler(orderServiceImpl);
        /*
		   5.根据上面提供的信息，创建代理对象 在这个过程中，
               a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
               b.然后根据相应的字节码转换成对应的class，
               c.然后调用newInstance()创建代理实例
		 */
        IOrderService proxy = (IOrderService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        // 调用代理的方法
        Order order = new Order();
        order.setObject("Hello");
        order.setUserId(1);
        proxy.saveOrder(order);
        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        // ProxyUtils.generateClassFile(userServiceImpl.getClass(), "UserServiceProxy");
    }
}
