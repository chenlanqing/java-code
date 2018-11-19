package com.blue.fish.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

@BTrace
public class PrintReturn {
	
	@OnMethod(
	        clazz="com.learning.example.demo.DemoController",
	        method="arg1",
	        location=@Location(Kind.RETURN)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, @Return AnyType result) {
		BTraceUtils.println(pcn+","+pmn + "," + result);
		BTraceUtils.println();
    }
}
