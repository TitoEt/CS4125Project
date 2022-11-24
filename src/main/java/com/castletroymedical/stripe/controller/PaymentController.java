package com.castletroymedical.stripe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.castletroymedical.stripe.dto.CreatePayment;
import com.castletroymedical.stripe.dto.CreatePaymentResponse;


@RestController

public class PaymentController {
    
  @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createPayment) throws StripeException {
         PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                .setAmount(15 * 100L)//create payment - payment calculator to be inserted here to calculate patients bill
                .setCurrency("eur") 
                .build();
      
            // Create a PaymentIntent with the order amount and currency
            PaymentIntent intent = PaymentIntent.create(createParams);
      
            return new CreatePaymentResponse(intent.getClientSecret());
            
          }

    }
  