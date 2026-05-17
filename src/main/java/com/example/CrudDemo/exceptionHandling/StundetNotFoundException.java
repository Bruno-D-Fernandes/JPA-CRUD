package com.example.CrudDemo.exceptionHandling;

public class StundetNotFoundException extends RuntimeException {

    public StundetNotFoundException(String message) {
        super(message);
    }

    public StundetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StundetNotFoundException(Throwable cause) {
        super(cause);
    }
}
