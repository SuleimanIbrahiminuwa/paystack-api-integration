package com.example.PaystackAPIIntegration.customExceptions;

public class InvalidReferenceNumberException extends RuntimeException{
    public InvalidReferenceNumberException(String message){
        super(message);
    }
}
