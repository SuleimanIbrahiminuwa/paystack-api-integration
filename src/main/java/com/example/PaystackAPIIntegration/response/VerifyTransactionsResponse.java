package com.example.PaystackAPIIntegration.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyTransactionsResponse {


    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;

    private Data data;

    @Getter
    @Setter
    public static class Data {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("domain")
        private String domain;

        @JsonProperty("status")
        private String status;

        @JsonProperty("reference")
        private String reference;


        @JsonProperty("amount")
        private Long amount;



        @JsonProperty("gateway_response")
        private String gatewayResponse;


        @JsonProperty("paidAt")
        private LocalDateTime paidAt;

        @JsonProperty("createdAt")
        private LocalDateTime createdAt;

        @JsonProperty("channel")
        private String channel;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("ipAddress")
        private String ipAddress;

        private Object metadata;

        private Log log;

        @JsonProperty("fees")
        private Long fees;

        private Authorization authorization;

        private Customer customer;

        @JsonProperty("requested_amount")
        private Long requestedAmount;
    }

    @Getter
    @Setter
    public class Log {
        @JsonProperty("start_time")
        private long startTime;

        @JsonProperty("time_spent")
        private int timeSpent;

        @JsonProperty("attempts")
        private int attempts;

        @JsonProperty("errors")
        private int errors;

        @JsonProperty("success")
        private boolean success;

        @JsonProperty("mobile")
        private boolean mobile;

        @JsonProperty("input")
        private List<Object> input;

        @JsonProperty("history")
        private List<LogHistory> history;

        @Getter
        @Setter
        public static class LogHistory {
            @JsonProperty("type")
            private String type;

            @JsonProperty("message")
            private String message;

            @JsonProperty("time")
            private int time;
        }
    }

    @Setter
    @Getter
    public static class Customer {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("metadata")
        private String metadata;

        @JsonProperty("customer_code")
        private String customerCode;

    }
    @Getter
    @Setter
    public  static class  Authorization {
        @JsonProperty("authorization_code")
        private String authorizationCode;

        @JsonProperty("bin")
        private String bin;

        @JsonProperty("last4")
        private String last4;

        @JsonProperty("exp_month")
        private String expMonth;

        @JsonProperty("exp_year")
        private String expYear;

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("bank")
        private String bank;

        @JsonProperty("country_code")
        private String countryCode;

        @JsonProperty("brand")
        private String brand;

        @JsonProperty("account_name")
        private String accountName;

    }

}
