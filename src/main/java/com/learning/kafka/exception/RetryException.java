package com.learning.kafka.exception;

public class RetryException extends RuntimeException{

    public RetryException() {
    }

    public RetryException(String message) {
        super(message);
    }

    public RetryException(Throwable cause) {
        super(cause);
    }
}
