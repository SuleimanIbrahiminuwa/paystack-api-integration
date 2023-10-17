package com.example.PaystackAPIIntegration.services;

import com.example.PaystackAPIIntegration.dto.UserDto;
import com.example.PaystackAPIIntegration.request.PayStackRequest;
import com.example.PaystackAPIIntegration.response.InitTransactionResponse;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface TransactionsService {

    InitTransactionResponse initializeTransactions(UserDto userDto) throws JSONException;
}
