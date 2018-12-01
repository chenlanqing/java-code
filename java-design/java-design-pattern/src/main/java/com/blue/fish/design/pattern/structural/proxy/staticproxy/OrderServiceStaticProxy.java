package com.blue.fish.design.pattern.structural.proxy.staticproxy;

import com.blue.fish.design.pattern.structural.proxy.IOrderService;
import com.blue.fish.design.pattern.structural.proxy.Order;
import com.blue.fish.design.pattern.structural.proxy.OrderServiceImpl;
import com.blue.fish.design.pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * OrderService静态代理类
 *
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    public int saveOrder(Order order){
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();

        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    /**
     * 类似于AOP中的beforeAdvice
     * @param order
     */
    private void beforeMethod(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db"+dbRouter+"】处理数据");

        //todo 设置dataSource;
        DataSourceContextHolder.setDBType("db"+String.valueOf(dbRouter));
        System.out.println("静态代理 before code");
    }

    /**
     * 类似于AOP中的afterAdvice
     */
    private void afterMethod(){
        System.out.println("静态代理 after code");
    }
}
