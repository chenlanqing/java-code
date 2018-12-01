package com.blue.fish.design.pattern.structural.proxy.cglib;

import com.blue.fish.design.pattern.structural.proxy.IOrderService;
import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.OrderServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class CgLibProxyClient {

    public static void main(String[] args) {
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceImpl.class);
        enhancer.setCallback(methodInterceptor);
        IOrderService subject = (IOrderService) enhancer.create();

        Order order = new Order();
        order.setUserId(1);
        subject.saveOrder(order);
    }
}
