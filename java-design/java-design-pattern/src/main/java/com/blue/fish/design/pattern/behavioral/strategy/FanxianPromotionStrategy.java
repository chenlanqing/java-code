package com.blue.fish.design.pattern.behavioral.strategy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class FanxianPromotionStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现促销活动");
    }
}
