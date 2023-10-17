package com.example.PaystackAPIIntegration.services.serviceImpl;
import com.example.PaystackAPIIntegration.customExceptions.InvalidAmountException;
import com.example.PaystackAPIIntegration.customExceptions.InvalidEmailExceptions;
import com.example.PaystackAPIIntegration.dto.UserDto;
import com.example.PaystackAPIIntegration.request.PayStackRequest;
import com.example.PaystackAPIIntegration.response.InitTransactionResponse;
import com.example.PaystackAPIIntegration.services.TransactionsService;
import com.example.PaystackAPIIntegration.utils.Constant;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionsService {

    @Value("${payStack.api.key}")
    private   String payStackApiKey;
    private static final Logger logger =  LoggerFactory.getLogger(TransactionServiceImpl.class);


    @Override
    public InitTransactionResponse initializeTransactions(UserDto userDto) {
        logger.info("inside controller: {}",userDto.getEmail());
        logger.info("inside controller amount: {}",userDto.getAmount());
        if(userDto.getEmail() == null || Objects.equals(userDto.getEmail(), "")){
            throw new InvalidEmailExceptions("Email Cannot be null");
        }
        else if (userDto.getAmount() == null || Objects.equals(userDto.getAmount(),"")){
            throw new InvalidAmountException("Amount cannot be empty");
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + payStackApiKey);

        PayStackRequest payload = generatePayload(userDto);

        HttpEntity<PayStackRequest> request = new HttpEntity<>(payload, headers);

        InitTransactionResponse body = restTemplate.exchange(
                Constant.INITIALIZE_TRANSACTIONS_API,
                HttpMethod.POST,
                request,
                InitTransactionResponse.class
        ).getBody();
        try {
            return InitTransactionResponse.builder()
                    .status(body.getStatus())
                    .message(body.getMessage())
                    .data(body.getData())
                    .build();
        } catch (Exception ex) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }
    }



    private PayStackRequest generatePayload(UserDto userDto){
        PayStackRequest jsono = PayStackRequest.builder()
                .email(userDto.getEmail())
                .amount(userDto.getAmount())
                .build();
        return jsono;
    }
}
