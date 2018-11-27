package com.blue.fish.design.pattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author bluefish 2018/11/26
 * @version 1.0.0
 */
@Slf4j
public class AC220 {

    public int outputAC220V() {
        int output = 220;
        log.info("输出交流电{}V", output);
        return output;
    }
}
