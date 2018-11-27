package com.blue.fish.design.pattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
@Slf4j
public class PowerAdapter implements DC5V{
    private AC220 ac220 = new AC220();

    @Override
    public int output5V() {
        int adapterInput = ac220.outputAC220V();

        int adapterOutput = adapterInput / 4;

        log.info("适用PowerAdapter输入AC:{}V，输出DC:{}V", adapterInput, adapterOutput);

        return adapterOutput;
    }
}
