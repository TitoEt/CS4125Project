package com.castletroymedical.stripe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class StripePaymentsApplication {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostConstruct
    public void setup() {
        Stripe.apiKey = stripeApiKey;
    }

    public static void main(String[] args) { SpringApplication.run(StripePaymnetsApplication)
    }
    
}
