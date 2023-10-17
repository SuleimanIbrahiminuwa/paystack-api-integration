package com.example.PaystackAPIIntegration.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayStackRequest {

    private String email;

    private String amount;

    private String reference;
}
