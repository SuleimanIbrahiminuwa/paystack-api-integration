package com.example.PaystackAPIIntegration.services.serviceImpl;

import com.example.PaystackAPIIntegration.customExceptions.InvalidReferenceNumberException;
import com.example.PaystackAPIIntegration.dto.ReferenceDto;
import com.example.PaystackAPIIntegration.request.PayStackRequest;
import com.example.PaystackAPIIntegration.response.VerifyTransactionsResponse;
import com.example.PaystackAPIIntegration.services.VerifyTransactions;
import com.example.PaystackAPIIntegration.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Objects;

@Service
public class VerifyTransactionServiceImpl implements VerifyTransactions {

    @Value("${payStack.api.key}")
    private  String payStackApiKey;
    private static final Logger logger =  LoggerFactory.getLogger(VerifyTransactionServiceImpl.class);

    @Override
    public VerifyTransactionsResponse verifyTransactions(ReferenceDto reference) {
        logger.info("An example log message: {}", reference);
        logger.info("payStackApiKey: {}", payStackApiKey);
        if(reference == null || Objects.equals(reference, "")){
            throw new InvalidReferenceNumberException("Invalid Reference number");
        }
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + payStackApiKey);
        String verifyUrl = Constant.VERIFY_TRANSACTIONS_API + reference.getReference();
        HttpEntity<PayStackRequest> request = new HttpEntity<>(headers);
        VerifyTransactionsResponse body = restTemplate.exchange(
                verifyUrl,
                HttpMethod.GET,
                request,
                VerifyTransactionsResponse.class
        ).getBody();
        try {
            return VerifyTransactionsResponse.builder()
                    .status(body.getStatus())
                    .message(body.getMessage())
                    .data(body.getData())
                    .build();
        } catch (Exception ex) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }
    }

}
