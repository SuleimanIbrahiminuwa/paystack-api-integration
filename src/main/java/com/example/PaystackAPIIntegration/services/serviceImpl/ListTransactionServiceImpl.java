package com.example.PaystackAPIIntegration.services.serviceImpl;

import com.example.PaystackAPIIntegration.response.TransactionListResponse;
import com.example.PaystackAPIIntegration.services.ListTransactions;
import com.example.PaystackAPIIntegration.utils.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Service
public class ListTransactionServiceImpl implements ListTransactions {

    @Value("${payStack.api.key}")
    private  String payStackApiKey;


    @Override
    public TransactionListResponse getAllTransactionsList() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + payStackApiKey);
        HttpEntity<Object> request = new HttpEntity<>(headers);

        TransactionListResponse body = restTemplate.exchange(
                Constant.LIST_TRANSACTIONS_API,
                HttpMethod.GET,
                request,
                TransactionListResponse.class
        ).getBody();

        try {
            return TransactionListResponse.builder()
                    .status(body.getStatus())
                    .message(body.getMessage())
                    .data(body.getData())
                    .build();
        } catch (Exception ex) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }
    }
}
