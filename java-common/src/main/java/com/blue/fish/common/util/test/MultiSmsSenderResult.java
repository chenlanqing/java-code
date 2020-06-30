/*
 * Copyright (c) 2020, 谊品到家 and/or its affiliates. All rights reserved.
 *
 */
package com.blue.fish.common.util.test;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Chen Lanqing 2020-04-16
 * @version 1.0.0
 */
@Data
public class MultiSmsSenderResult {

    private int result;
    private String errMsg;
    private String ext;
    private ArrayList<SingleSmsSenderResult> detail;
}