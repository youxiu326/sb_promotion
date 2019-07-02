package com.youxiu326.exception;

/**
 * 自定义异常
 */
public class ServiceException extends Exception {

    private Exception exception;

    public ServiceException(String message, Exception exception) {
        super(message);
        this.exception = exception;
    }

    public ServiceException(String message) {
        this(message, null);
    }

    public ServiceException(Exception exception) {
        this(null, exception);
    }

    public Exception getException() {
        return exception;
    }

    public Exception getRootCause() {
        if (exception instanceof ServiceException) {
            return ((ServiceException) exception).getRootCause();
        }
        return exception == null ? this : exception;
    }

    @Override
    public String toString() {
        if (exception instanceof ServiceException) {
            return ((ServiceException) exception).toString();
        }
        return exception == null ? super.toString() : exception.toString();
    }
} 