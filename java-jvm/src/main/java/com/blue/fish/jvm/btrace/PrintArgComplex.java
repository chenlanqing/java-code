package com.blue.fish.jvm.btrace;

import com.learning.example.netty.codec.serialize.UserInfo;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

@BTrace
public class PrintArgComplex {
	
	
	@OnMethod(
	        clazz="com.learning.example.demo.DemoController",
	        method="arg2",
	        location=@Location(Kind.ENTRY)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, UserInfo user) {
		//print all fields
		BTraceUtils.printFields(user);
		//print one field
		Field filed2 = BTraceUtils.field("com.learning.example.netty.codec.serialize.UserInfo", "name");
		BTraceUtils.println(BTraceUtils.get(filed2, user));
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}