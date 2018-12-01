package com.blue.fish.design.pattern.behavioral.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> strategyMap = new ConcurrentHashMap<>();

    static {
        strategyMap.put(PromotionKey.lijian, new LijianPromotionStrategy());
        strategyMap.put(PromotionKey.manjian, new ManjianPromotionStrategy());
        strategyMap.put(PromotionKey.fanxian, new FanxianPromotionStrategy());
    }

    private static final PromotionStrategy empty = new EmptyPromotionStrategy();

    public static PromotionStrategy getPromotionStrategy(String key){
        PromotionStrategy promotionStrategy = strategyMap.get(key);
        return promotionStrategy == null ? empty : promotionStrategy;
    }


    private interface PromotionKey{
        String fanxian = "fanxian";
        String lijian = "lijian";
        String manjian = "manjian";
    }
}
