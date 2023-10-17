package com.example.PaystackAPIIntegration.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionListResponse {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private List<Data> data;

    @JsonProperty("meta")
    private Meta meta;

    @Getter
    @Setter
    public static class Data {
        @JsonProperty("id")
        private long id;

        @JsonProperty("domain")
        private String domain;

        @JsonProperty("status")
        private String status;

        @JsonProperty("reference")
        private String reference;

        @JsonProperty("amount")
        private long amount;

        @JsonProperty("message")
        private String message;

        @JsonProperty("gateway_response")
        private String gatewayResponse;

        @JsonProperty("paid_at")
        private String paidAt;

        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("channel")
        private String channel;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("ip_address")
        private String ipAddress;

        @JsonProperty("metadata")
        private Metadata metadata;

        @JsonProperty("log")
        private Object log;

        @JsonProperty("fees")
        private Object fees;

        @JsonProperty("paidAt")
        private String paidAtTimestamp;

        @JsonProperty("createdAt")
        private String createdAtTimestamp;

        @JsonProperty("authorization")
        private Authorization authorization;

        @JsonProperty("customer")
        private Customer customer;

        @JsonProperty("requested_amount")
        private long requestedAmount;
    }

    @Getter
    @Setter
    public static class Metadata {
        @JsonProperty("custom_fields")
        private List<CustomField> customFields;
    }

    @Getter
    @Setter
    public static class CustomField {
        @JsonProperty("display_name")
        private String displayName;

        @JsonProperty("variable_name")
        private String variableName;

        @JsonProperty("value")
        private String value;

    }

    @Getter
    @Setter
    public static class Authorization {
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

    @Getter
    @Setter
    public static class Customer {
        @JsonProperty("id")
        private long id;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("customer_code")
        private String customerCode;

        @JsonProperty("metadata")
        private Object metadata;

        @JsonProperty("risk_action")
        private String riskAction;
    }

    @Getter
    @Setter
    public static class Meta {
        @JsonProperty("total")
        private int total;

        @JsonProperty("skipped")
        private int skipped;

        @JsonProperty("perPage")
        private int perPage;

        @JsonProperty("page")
        private int page;

        @JsonProperty("pageCount")
        private int pageCount;

    }
}
