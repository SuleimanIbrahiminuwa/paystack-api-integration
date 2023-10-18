package com.example.PaystackAPIIntegration;

import com.example.PaystackAPIIntegration.dto.ReferenceDto;
import com.example.PaystackAPIIntegration.request.PayStackRequest;
import com.example.PaystackAPIIntegration.response.VerifyTransactionsResponse;
import com.example.PaystackAPIIntegration.services.serviceImpl.VerifyTransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(TestConfig.class)
public class VerifyTransactionServiceImplTest {

    @InjectMocks
    private VerifyTransactionServiceImpl verifyTransactionService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private  String payStackApiKey = "sk_test_61377fe89e5310b64e235c9b6168fda62ae3db6c";

    @Test
    public void testVerifyTransactions() {

        ReferenceDto referenceDto = new ReferenceDto();
        referenceDto.setReference("pt4lckjni7");

        // mocking response
        VerifyTransactionsResponse expectedResponse = new VerifyTransactionsResponse();
        expectedResponse.setStatus(true);
        expectedResponse.setMessage("Transaction verified successfully");


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + payStackApiKey);

        HttpEntity<PayStackRequest> request = new HttpEntity<>(headers);

        // Mocking restTemplate behavior
        when(restTemplate.exchange(
                eq("https://api.paystack.co/transaction/verify/pt4lckjni7"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(VerifyTransactionsResponse.class),
                eq(request)
                )).thenReturn(ResponseEntity.ok(expectedResponse));

        // Calling the service method
        VerifyTransactionsResponse actualResponse = verifyTransactionService.verifyTransactions(referenceDto);

        // Assertions
        assertEquals("success", actualResponse.getStatus());
        assertEquals("Transaction verified successfully", actualResponse.getMessage());
    }
}
