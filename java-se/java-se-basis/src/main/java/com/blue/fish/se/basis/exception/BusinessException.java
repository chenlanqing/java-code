package com.blue.fish.se.basis.exception;

/**
 * @author bluefish 2019-07-08
 * @version 1.0.0
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = 8279371359935089642L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
