package com.microsoft.petstoreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetstoreappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreappApplication.class, args);

		System.out.println("Testing git");
	}
}
