package com.copus.v1.service.exception;

public class NoFilterForSeojiPreviewException extends RuntimeException {
    public NoFilterForSeojiPreviewException() {


    }

    public NoFilterForSeojiPreviewException(String message) {
        super(message);
    }

    public NoFilterForSeojiPreviewException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFilterForSeojiPreviewException(Throwable cause) {
        super(cause);
    }

    protected NoFilterForSeojiPreviewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
