package com.blue.fish.design.pattern.structural.proxy.dynamicproxy;

import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.db.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class OrderServiceDynamicProxy implements InvocationHandler{

    private Object target;

    public OrderServiceDynamicProxy(Object target) {
        this.target = target;
    }

    public Object bind(){
        Class<?> clazz = target.getClass();
        // newProxyInstance:首先获取了代理类的运行时Class引用，然后调用了这个Class中的构造方法，这个构造方法只有一个参数，正是InvocationHandler接口，由此产生了一个代理类的实例
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object arg = args[0];
        beforeMethod(arg);

        Object object = method.invoke(target, args);

        afterMethod();
        return object;
    }

    private void beforeMethod(Object obj){
        int userId = 0;
        System.out.println("动态代理 before code");
        if(obj instanceof Order){
            Order order = (Order)obj;
            userId = order.getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("动态代理分配到【db"+dbRouter+"】处理数据");

        //todo 设置dataSource;
        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));
    }

    private void afterMethod(){
        System.out.println("动态代理 after code");
    }
}
