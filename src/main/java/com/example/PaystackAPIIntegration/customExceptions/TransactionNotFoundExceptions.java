package com.example.PaystackAPIIntegration.customExceptions;

public class TransactionNotFoundExceptions extends Exception{
    public TransactionNotFoundExceptions(String message) {
        super(message);
    }
}
