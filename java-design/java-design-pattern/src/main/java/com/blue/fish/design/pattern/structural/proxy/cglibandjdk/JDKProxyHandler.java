package com.blue.fish.design.pattern.structural.proxy.cglibandjdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


@Slf4j
public class JDKProxyHandler implements InvocationHandler {

    private Object target;

    @SuppressWarnings("rawtypes")
    public JDKProxyHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            log.error("Create proxy for {} failed", clazz.getName());
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preAction();
        Object result = method.invoke(target, args);
        postAction();
        return result;
    }

    private void preAction() {
//        log.info("JDKProxyHandler.preAction()");
    }

    private void postAction() {
//        log.info("JDKProxyHandler.postAction()");
    }

}