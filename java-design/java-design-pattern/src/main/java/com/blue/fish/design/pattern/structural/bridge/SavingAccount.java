package com.blue.fish.design.pattern.structural.bridge;

/**
 * @author bluefish 2018/11/28
 * @version 1.0.0
 */
public class SavingAccount implements Account{
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
