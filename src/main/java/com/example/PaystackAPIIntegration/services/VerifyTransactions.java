package com.example.PaystackAPIIntegration.services;

import com.example.PaystackAPIIntegration.dto.ReferenceDto;
import com.example.PaystackAPIIntegration.response.VerifyTransactionsResponse;

public interface VerifyTransactions {

    public VerifyTransactionsResponse verifyTransactions(ReferenceDto reference);
}
