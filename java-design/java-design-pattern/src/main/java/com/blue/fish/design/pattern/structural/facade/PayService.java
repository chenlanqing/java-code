package com.blue.fish.design.pattern.structural.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Slf4j
public class PayService {

    public boolean pay(Order order){
        log.info("订单支付成功");
        return true;
    }
}
