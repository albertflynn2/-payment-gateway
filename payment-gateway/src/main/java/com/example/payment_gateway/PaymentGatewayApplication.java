package com.example.payment_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PaymentGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayApplication.class, args);
	}
}