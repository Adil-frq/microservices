package com.microservices.exception;

public class RatingException extends RuntimeException{

    public RatingException(String message) {
        super(message);
    }
}
