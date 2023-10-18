package com.example.PaystackAPIIntegration;

import com.example.PaystackAPIIntegration.dto.UserDto;
import com.example.PaystackAPIIntegration.response.InitTransactionResponse;
import com.example.PaystackAPIIntegration.services.serviceImpl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest

public class InitTransactionServiceImpTest {

        @Autowired
        private  TransactionServiceImpl transactionService;

        @Test
        public void testInitializeTransactions() {
            UserDto userDto = new UserDto();
            userDto.setEmail("test@example.com");
            userDto.setAmount("100");

            InitTransactionResponse response = transactionService.initializeTransactions(userDto);

            assertNotNull(response);
            assertEquals("success", response.getStatus());
            assertEquals("Transaction initialized successfully", response.getMessage());
        }
}
