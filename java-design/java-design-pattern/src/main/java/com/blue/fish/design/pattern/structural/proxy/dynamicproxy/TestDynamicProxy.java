package com.blue.fish.design.pattern.structural.proxy.dynamicproxy;

import com.blue.fish.design.pattern.structural.proxy.IOrderService;
import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.OrderServiceImpl;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        IOrderService proxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        proxy.saveOrder(order);
    }
}
