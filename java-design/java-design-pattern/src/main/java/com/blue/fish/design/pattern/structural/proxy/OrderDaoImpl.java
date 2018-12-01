package com.blue.fish.design.pattern.structural.proxy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class OrderDaoImpl implements IOrderDao{
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
