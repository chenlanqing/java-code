package com.blue.fish.spring.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author bluefish 2020-03-09
 * @version 1.0.0
 */
public class TargetInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截在方法前和方法后加入业务
     *
     * @param obj    目标对象
     * @param method 目标方法
     * @param params 参数，
     * @param proxy  CGlib方法代理对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy proxy) throws Throwable {
        System.out.println("调用前");
        Object result = proxy.invokeSuper(obj, params);
        System.out.println(" 调用后" + result);
        return result;
    }
}
