package com.Walmart.WalmartOrder;

import org.springframework.beans.factory.BeanRegistrarDslMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WalmartOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalmartOrderApplication.class, args);
	}
		@Bean
		@LoadBalanced
		public RestTemplate restTemplate()
		{
			return new RestTemplate();
		}

	}
