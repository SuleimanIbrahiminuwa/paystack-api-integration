package com.example.PaystackAPIIntegration;

import com.example.PaystackAPIIntegration.controller.TransactionsController;
import com.example.PaystackAPIIntegration.dto.ReferenceDto;
import com.example.PaystackAPIIntegration.dto.UserDto;
import com.example.PaystackAPIIntegration.response.InitTransactionResponse;
import com.example.PaystackAPIIntegration.response.TransactionListResponse;
import com.example.PaystackAPIIntegration.response.VerifyTransactionsResponse;
import com.example.PaystackAPIIntegration.services.serviceImpl.ListTransactionServiceImpl;
import com.example.PaystackAPIIntegration.services.serviceImpl.TransactionServiceImpl;
import com.example.PaystackAPIIntegration.services.serviceImpl.VerifyTransactionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionsController.class)
public class TransactionsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VerifyTransactionServiceImpl verifyTransactionService;

    @MockBean
    private TransactionServiceImpl transactionService;

    @MockBean
    private ListTransactionServiceImpl listTransactionService;

    @Test
    public void testInitializeTransaction() throws Exception {
        // Prepare a UserDto for testing
        UserDto userDto = new UserDto();
        userDto.setEmail("test@example.com");
        userDto.setAmount("100");

        // Mock the behavior of the transactionService
        when(transactionService.initializeTransactions(any(UserDto.class))).thenReturn(
                InitTransactionResponse.builder()
                        .status(true)
                        .message("Transaction initialized successfully")
                        .data(null)
                        .build()
        );

        // Perform the POST request to the /initTransactions endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/initTransactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.status").value("success"))
                .andExpect((ResultMatcher) jsonPath("$.message").value("Transaction initialized successfully"));
    }

    @Test
    public void testGetTransactions() throws Exception {
        String reference = "pt4lckjni7";

        // Mock the behavior of the verifyTransactionService
        when(verifyTransactionService.verifyTransactions(any(ReferenceDto.class))).thenReturn(
                VerifyTransactionsResponse.builder()
                        .status(true)
                        .message("Transaction verified successfully")
                        .data(null)
                        .build()
        );

        // Perform the GET request to the /getTransactions/{reference} endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/getTransactions/{reference}", reference))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.status").value("success"))
                .andExpect((ResultMatcher) jsonPath("$.message").value("Transaction verified successfully"));
    }

    @Test
    public void testGetTransactionList() throws Exception {
        // Mock the behavior of the listTransactionService
        when(listTransactionService.getAllTransactionsList()).thenReturn(
                TransactionListResponse.builder()
                        .status(true)
                        .message("Transactions retrieved successfully")
                        .data(null)
                        .build()
        );

        // Perform the GET request to the /getTransactionList endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/getTransactionList"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.status").value("success"))
                .andExpect((ResultMatcher) jsonPath("$.message").value("Transactions retrieved successfully"));
    }
}
