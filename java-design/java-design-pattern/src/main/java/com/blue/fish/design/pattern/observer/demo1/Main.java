package com.blue.fish.design.pattern.observer.demo1;

public class Main {
    public static void main(String[] args) {
        ConcreteObserver1 o1 = new ConcreteObserver1();
        ConcreteObserver2 o2 = new ConcreteObserver2();
        ConcreteObserver3 o3 = new ConcreteObserver3();

        ConcreteSubject1 s1 = new ConcreteSubject1("天气");
        s1.registerObserver(o1);
        s1.registerObserver(o2);

        ConcreteSubject1 s2 = new ConcreteSubject1("新闻");
        s2.registerObserver(o1);
        s2.registerObserver(o3);


        s1.change();
        s2.change();
    }
}
