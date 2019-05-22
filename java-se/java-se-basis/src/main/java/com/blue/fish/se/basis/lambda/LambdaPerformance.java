package com.blue.fish.se.basis.lambda;

import com.blue.fish.common.entity.UserInfo;
import org.openjdk.jmh.annotations.Setup;

import java.util.List;

/**
 * Lambda表达式性能测试
 *
 * @author bluefish 2019-05-16
 * @version 1.0.0
 */
public class LambdaPerformance {

    private List<UserInfo> userList;

    @Setup
    public void prepare(){

    }
}
