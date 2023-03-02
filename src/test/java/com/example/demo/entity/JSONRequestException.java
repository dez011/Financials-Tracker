package com.example.demo.entity;

public class JSONRequestException extends RuntimeException {
    public JSONRequestException(){super();}
    public JSONRequestException(String request_is_null) {
        super(request_is_null);
    }
    public JSONRequestException(Throwable cause){super(cause);}
    public JSONRequestException(String message, Throwable cause){super(message, cause);}
}
