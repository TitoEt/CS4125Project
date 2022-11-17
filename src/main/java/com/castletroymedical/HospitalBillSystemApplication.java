package com.castletroymedical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("database.repository")
@ComponentScan(basePackages={"database.*"})
@EntityScan("database.entity")   
public class HospitalBillSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalBillSystemApplication.class, args);
	}

}
