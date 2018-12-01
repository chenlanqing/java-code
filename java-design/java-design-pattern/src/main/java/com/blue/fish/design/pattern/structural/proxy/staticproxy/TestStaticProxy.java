package com.blue.fish.design.pattern.structural.proxy.staticproxy;

import com.blue.fish.design.pattern.structural.proxy.Order;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy();
        proxy.saveOrder(order);
    }
}
