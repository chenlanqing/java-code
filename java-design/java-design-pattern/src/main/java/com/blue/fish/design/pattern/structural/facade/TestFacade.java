package com.blue.fish.design.pattern.structural.facade;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
public class TestFacade {

    public static void main(String[] args) {
        Order order = new Order(1L, 10);
        OrderService orderService =new OrderService();

        orderService.createOrder(order);
    }
}
