package com.example.demo.exception;


public class JsonSQL4JException extends RuntimeException {

    public JsonSQL4JException(String message) {
        super(message);
    }

    public JsonSQL4JException(String message, Throwable cause) {
        super(message, cause);
    }

}
