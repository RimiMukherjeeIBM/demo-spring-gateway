package com.example.demospringgateway;

import com.example.demospringgateway.filter.AuthFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSpringGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringGatewayApplication.class, args);
	}


}
