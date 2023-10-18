package com.example.PaystackAPIIntegration.controller;

import com.example.PaystackAPIIntegration.dto.ReferenceDto;
import com.example.PaystackAPIIntegration.dto.UserDto;
import com.example.PaystackAPIIntegration.response.InitTransactionResponse;
import com.example.PaystackAPIIntegration.response.TransactionListResponse;
import com.example.PaystackAPIIntegration.response.VerifyTransactionsResponse;
import com.example.PaystackAPIIntegration.services.serviceImpl.ListTransactionServiceImpl;
import com.example.PaystackAPIIntegration.services.serviceImpl.TransactionServiceImpl;
import com.example.PaystackAPIIntegration.services.serviceImpl.VerifyTransactionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "User Transactions Management APIs")
public class TransactionsController {

    private static final Logger logger =  LoggerFactory.getLogger(TransactionsController.class);


    private final VerifyTransactionServiceImpl verifyTransactionService;
    private final TransactionServiceImpl transactionService;

    private final ListTransactionServiceImpl listTransactionService;



    @Operation(
            summary = "Initiate Transactions",
            description = "Initiated transactions for user"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "http status 200 Initiated"
    )
    @PostMapping("/initTransactions")
    public InitTransactionResponse initializeTransaction(@Valid @RequestBody UserDto userDto){
        logger.info("An example log message: {}", userDto.getEmail());
        return transactionService.initializeTransactions(userDto);
    }

    @Operation(
            summary = "Verify Transactions",
            description = "Verify  transactions for user using reference number"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "http status 200 Verify"
    )
    @GetMapping("/getTransactions/{reference}")
    public VerifyTransactionsResponse getTransactions(@PathVariable String reference){
        logger.info("An example log message: {}", reference);
        ReferenceDto referenceDto = new ReferenceDto();
        referenceDto.setReference(reference);
        return verifyTransactionService.verifyTransactions(referenceDto);
    }

    @Operation(
            summary = "Get Transactions List",
            description = "Get transactions List for user"
    )
    @ApiResponse(
            responseCode = "20O",
            description = "http status 200 Fetch"
    )
    @GetMapping("/getTransactionList")
    public TransactionListResponse getTransactionList(){
        return listTransactionService.getAllTransactionsList();
    }
}
