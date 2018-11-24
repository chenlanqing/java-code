package com.blue.fish.design.pattern.structural.facade;


import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Slf4j
public class StockService {

    public boolean isStockAvaliable(Order order) {
        log.info("校验订单库存通过，库存数量： {}", order.getCount());

        return true;
    }
}
