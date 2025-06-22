package com.mariano.rover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mariano.rover.models")
public class RoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoverApplication.class, args);
	}

}
