package com.example.PaystackAPIIntegration;

import com.example.PaystackAPIIntegration.response.TransactionListResponse;
import com.example.PaystackAPIIntegration.services.serviceImpl.ListTransactionServiceImpl;
import com.example.PaystackAPIIntegration.utils.Constant;
import lombok.Value;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class testGetAllTransactionsList {
    @InjectMocks
    private ListTransactionServiceImpl listTransactionService;

    @Mock
    private RestTemplate restTemplate;


    private String payStackApiKey ="sk_test_61377fe89e5310b64e235c9b6168fda62ae3db6c";

    @Test
    public void testGetAllTransactionsList() {
        TransactionListResponse expectedResponse = new TransactionListResponse();
        expectedResponse.setStatus(true);
        expectedResponse.setMessage("Transactions retrieved successfully");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + payStackApiKey);

        HttpEntity<Object> request = new HttpEntity<>(headers);

        when(restTemplate.exchange(
                eq(Constant.LIST_TRANSACTIONS_API),
                eq(HttpMethod.GET),
                eq(request),
                eq(TransactionListResponse.class)
        )).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        TransactionListResponse actualResponse = listTransactionService.getAllTransactionsList();

        assertNotNull(actualResponse);
        assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
        assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
    }
}
