package com.example.PaystackAPIIntegration.customExceptions;

public class InvalidEmailExceptions extends RuntimeException{
    public  InvalidEmailExceptions(String message){
        super(message);
    }
}
