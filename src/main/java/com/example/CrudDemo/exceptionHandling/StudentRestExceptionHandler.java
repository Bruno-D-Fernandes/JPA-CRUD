package com.example.CrudDemo.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// O que é? Intrincicamente
@ControllerAdvice
public class StudentRestExceptionHandler {
    // Aqui está o tratamento de erro real, isso não deveria estar em uma pasta separada?

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExceptionNotFound(StundetNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        // existem outras formas de se fazer isso
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericExc(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        // existem outras formas de se fazer isso
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
