package com.blue.fish.design.pattern.structural.facade;

import lombok.Data;

/**
 * @author bluefish 2018/11/24
 * @version 1.0.0
 */
@Data
public class Order {

    private Long id;
    private Integer count;

    public Order(Long id, Integer count) {
        this.id = id;
        this.count = count;
    }
}
