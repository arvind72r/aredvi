package com.aredvi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.aredvi.entity")
public class AredviApplication {

	public static void main(String[] args) {
		SpringApplication.run(AredviApplication.class, args);
	}
}
