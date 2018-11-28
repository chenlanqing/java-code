package com.blue.fish.design.pattern.structural.bridge;

/**
 * @author bluefish 2018/11/28
 * @version 1.0.0
 */
public class ABCBank extends Bank{

    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
