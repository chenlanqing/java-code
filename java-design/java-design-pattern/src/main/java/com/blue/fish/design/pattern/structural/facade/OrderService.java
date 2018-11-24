package com.blue.fish.design.pattern.structural.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Slf4j
public class OrderService {

    private PayService payService = new PayService();
    private StockService stockService = new StockService();
    private ShippingService shippingService = new ShippingService();

    public void createOrder(Order order){
        if (stockService.isStockAvaliable(order)) {
            if (payService.pay(order)) {
                String orderNo = shippingService.shipping(order);
                log.info("创建订单成功，订单号：{}", orderNo);
            }
        }
    }
}
