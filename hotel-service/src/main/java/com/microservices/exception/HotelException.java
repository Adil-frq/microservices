package com.microservices.exception;

public class HotelException extends RuntimeException{
    public HotelException(String message) {
        super(message);
    }
}
