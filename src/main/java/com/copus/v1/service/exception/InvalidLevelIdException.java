package com.copus.v1.service.exception;

public class InvalidLevelIdException extends RuntimeException {
    public InvalidLevelIdException() {
        super();
    }

    public InvalidLevelIdException(String message) {
        super(message);
    }

    public InvalidLevelIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLevelIdException(Throwable cause) {
        super(cause);
    }

    protected InvalidLevelIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
