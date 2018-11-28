package com.blue.fish.design.pattern.structural.bridge;

/**
 * @author bluefish 2018/11/28
 * @version 1.0.0
 */
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
