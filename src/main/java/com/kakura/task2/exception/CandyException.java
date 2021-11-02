package com.kakura.task2.exception;

public class CandyException extends Exception {
    public CandyException() {
        super();
    }

    public CandyException(String message) {
        super(message);
    }

    public CandyException(Exception e) {
        super(e);
    }

    public CandyException(String message, Exception e) {
        super(message, e);
    }
}
