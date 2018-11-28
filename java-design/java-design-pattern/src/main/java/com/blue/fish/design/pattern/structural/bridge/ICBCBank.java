package com.blue.fish.design.pattern.structural.bridge;

/**
 * @author bluefish 2018/11/28
 * @version 1.0.0
 */
public class ICBCBank extends Bank{

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
