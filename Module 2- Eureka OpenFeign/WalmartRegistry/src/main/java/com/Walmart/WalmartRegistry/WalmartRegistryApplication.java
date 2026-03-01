package com.Walmart.WalmartRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WalmartRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalmartRegistryApplication.class, args);
	}

}
