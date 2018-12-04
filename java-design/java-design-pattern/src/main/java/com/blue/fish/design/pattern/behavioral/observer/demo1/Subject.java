package com.blue.fish.design.pattern.behavioral.observer.demo1;

/**
 * 被观察者姓名
 */
public abstract class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    /**
     * 注册观察者
     *
     * @param observer
     * @return
     */
    public abstract boolean registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     * @return
     */
    public abstract boolean removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    public abstract void notifyObserver();

    /**
     * 被观察者更改
     */
    public abstract void change();
}
