package com.blue.fish.design.pattern.behavioral.strategy;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class TestStrategy {

    public static void main(String[] args) {

//        PromotionStrategy lijian = new LijianPromotionStrategy();
//        lijian.doPromotion();
//
//        PromotionStrategy manjian = new ManjianPromotionStrategy();
//        manjian.doPromotion();


        PromotionStrategy lijian = PromotionStrategyFactory.getPromotionStrategy("lijian");
        lijian.doPromotion();

        PromotionStrategy lijianxxxx = PromotionStrategyFactory.getPromotionStrategy("lijianxxxx");
        lijianxxxx.doPromotion();
    }
}
