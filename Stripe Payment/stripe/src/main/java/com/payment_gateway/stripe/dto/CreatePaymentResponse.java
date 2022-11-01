package com.payment_gateway.stripe.dto;

public class CreatePaymentResponse {
    private String clientSecret;

    public String createPaymentResponse(String clientSecret) {return this.clientSecret;}
    
}
