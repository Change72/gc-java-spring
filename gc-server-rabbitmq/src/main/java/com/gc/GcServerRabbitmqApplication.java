package com.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GcServerRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcServerRabbitmqApplication.class, args);
	}

}

