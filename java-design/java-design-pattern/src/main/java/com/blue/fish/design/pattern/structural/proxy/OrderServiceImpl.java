package com.blue.fish.design.pattern.structural.proxy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class OrderServiceImpl implements IOrderService{
    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        iOrderDao = new OrderDaoImpl();
        System.out.println("service层调用dao层添加order成功");

        return iOrderDao.insert(order);
    }
}
