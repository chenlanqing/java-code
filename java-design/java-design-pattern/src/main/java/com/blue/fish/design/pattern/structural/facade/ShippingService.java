package com.blue.fish.design.pattern.structural.facade;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Slf4j
public class ShippingService {

    public String shipping(Order order){
        log.info("{} 进入物流中心", order.getId());
        return UUID.randomUUID().toString().replace("-","");
    }
}
