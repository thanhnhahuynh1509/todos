package com.api.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundExceptionHandler(NotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ErrorResponse userExistsExceptionHandler(UserExistsException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
