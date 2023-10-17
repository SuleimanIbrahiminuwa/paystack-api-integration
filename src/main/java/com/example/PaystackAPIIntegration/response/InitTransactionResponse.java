package com.example.PaystackAPIIntegration.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InitTransactionResponse {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("message")
    private String message;

    private Data data;

    @Setter
    @Getter
   public static class Data {

       @JsonProperty("authorization_url")
       private String authorization_url;

       @JsonProperty("access_code")
       private String access_code;


       @JsonProperty("reference")
       private String reference;
   }

}


