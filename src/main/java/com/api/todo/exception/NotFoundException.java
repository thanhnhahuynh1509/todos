package com.api.todo.exception;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message) {
        super(message);
    }

}
