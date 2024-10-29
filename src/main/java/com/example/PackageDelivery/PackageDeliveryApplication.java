package com.example.PackageDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com/example/PackageDelivery/Entities"})
@EnableJpaRepositories("com.example.PackageDelivery.Repository")
public class PackageDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackageDeliveryApplication.class, args);
	}

}
