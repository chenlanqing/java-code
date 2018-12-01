package com.blue.fish.design.pattern.structural.proxy.cglibandjdk;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author bluefish 2018/12/1
 * @version 1.0.0
 */
@Slf4j
public class CGLibInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        preAction();

        Object result = methodProxy.invokeSuper(o, objects);

        postAction();

        return result;
    }

    private void preAction() {
//        log.info("CGLibInterceptor.preAction()");
    }

    private void postAction() {
//        log.info("CGLibInterceptor.postAction()");
    }
}
