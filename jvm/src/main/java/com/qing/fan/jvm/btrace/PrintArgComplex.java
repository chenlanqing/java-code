package com.qing.fan.jvm.btrace;

import com.qing.fan.common.entity.UserInfo;
import org.openjdk.btrace.core.BTraceUtils;
import org.openjdk.btrace.core.annotations.*;

import java.lang.reflect.Field;

@BTrace
public class PrintArgComplex {


    @OnMethod(
            clazz = "com.learning.example.demo.DemoController",
            method = "arg2",
            location = @Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, UserInfo user) {
        //print all fields
        BTraceUtils.printFields(user);
        //print one field
        Field filed2 = BTraceUtils.field("com.qing.fan.common.entity.UserInfo", "name");
        BTraceUtils.println(BTraceUtils.get(filed2, user));
        BTraceUtils.println(pcn + "," + pmn);
        BTraceUtils.println();
    }
}