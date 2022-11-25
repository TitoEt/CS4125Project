package com.castletroymedical;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.stripe.Stripe;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories("database.repository")
@ComponentScan(basePackages={"com.castletroymedical"})
@EntityScan("database.entity")   
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
