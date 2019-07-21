package com.blue.fish.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class UserAspect {

    public void beforeAdvice() {
        System.out.println("前置通知");
    }

    public void afterAdvice() {
        System.out.println("后置通知");
    }

    public void afterReturnAdvice() {
        System.out.println("返回通知");
    }

    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知之前");
        Object result = joinPoint.proceed();
        System.out.println("环绕通知之后");
        return result;
    }
}
