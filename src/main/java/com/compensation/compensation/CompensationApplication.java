package com.compensation.compensation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CompensationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompensationApplication.class, args);
	}

}
