package com.learning.kafka.exception;

public class NotRetryException extends RuntimeException{

    public NotRetryException() {
    }

    public NotRetryException(String message) {
        super(message);
    }

    public NotRetryException(Throwable cause) {
        super(cause);
    }
}
