package com.blue.fish.se.basis.exception;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class ExceptionChainTest {

    public static void main(String[] args) {
//        constructorArgsChain();

        initCause();
    }

    public static void originException() throws BusinessException {
        throw new BusinessException("业务异常。。。。");
    }

    public static void constructorArgsChain() {
        try {
            originException();
        } catch (BusinessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initCause() {
        try {
            originException();
        } catch (BusinessException e) {
            RuntimeException ex = new RuntimeException("系统异常，请联系管理员");
            ex.initCause(e);
            throw ex;
        }
    }
}
