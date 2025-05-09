package com.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories(basePackages = "com.infrastructure.persistence.jpa")
@EntityScan(basePackages = "com.infrastructure.entity")
public class HolidayApiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolidayApiSpringbootApplication.class, args);
	}

}
