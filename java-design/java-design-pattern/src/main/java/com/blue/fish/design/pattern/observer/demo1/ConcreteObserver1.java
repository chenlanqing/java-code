package com.blue.fish.design.pattern.observer.demo1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteObserver1 implements Observer{

    @Override
    public void update(Subject subject) {
        log.info("我是观察者~~~~~1，被观察者：{} 发生了变化", subject.getName());
        log.info("观察者1作出响应");
    }
}
