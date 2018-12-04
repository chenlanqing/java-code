package com.blue.fish.design.pattern.behavioral.observer.demo1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConcreteSubject2 extends Subject {

    private boolean state;

    public ConcreteSubject2(String name) {
        super(name);
    }

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public boolean registerObserver(Observer observer) {
        return observerList.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observerList) {
            o.update(this);
        }
    }

    @Override
    public void change() {
        log.info("我是被观察者：{}，我已经修改了", getName());
        notifyObserver();
    }
}
