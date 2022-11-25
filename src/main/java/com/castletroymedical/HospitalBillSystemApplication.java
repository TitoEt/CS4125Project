package com.castletroymedical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.castletroymedical.billing.InvoiceBuilder;

@SpringBootApplication
@EnableJpaRepositories("database.repository")
@ComponentScan(basePackages={"database.*"})
@EntityScan("database.entity")
public class HospitalBillSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(HospitalBillSystemApplication.class, args);
		InvoiceBuilder ib = new InvoiceBuilder();
		ib.buildConsultation();
		ib.buildConsultation();
		ib.buildPrivateRoom(5);
		System.out.println(ib.getInvoice().getCharge());
	}

}
