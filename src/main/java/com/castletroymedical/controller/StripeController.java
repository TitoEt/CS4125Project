package com.castletroymedical.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.castletroymedical.dto.CreatePayment;
import com.castletroymedical.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;


@RestController

public class StripeController {
    
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
    