package com.example.PaystackAPIIntegration.customExceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }

}
