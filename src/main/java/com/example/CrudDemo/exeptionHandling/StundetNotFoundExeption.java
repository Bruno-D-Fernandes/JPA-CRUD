package com.example.CrudDemo.exeptionHandling;

public class StundetNotFoundExeption extends RuntimeException {

    public StundetNotFoundExeption(String message) {
        super(message);
    }

    public StundetNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public StundetNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
