package com.castletroymedical;

import javax.annotation.PostConstruct;

import com.stripe.Stripe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication
public class HospitalBillSystemApplication {
	@Value("${stripe.api.key}")
    private String stripeApiKey;

	@PostConstruct
    public void setup() {
        Stripe.apiKey = stripeApiKey;
    }
	public static void main(String[] args) {
		SpringApplication.run(HospitalBillSystemApplication.class, args); 
	}
}
