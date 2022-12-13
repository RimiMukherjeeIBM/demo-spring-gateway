package com.example.demospringgateway;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@OpenAPIDefinition(info = @Info(title = "rws-service", description = "REST API Endpoints",
		termsOfService = "http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open",
		contact = @Contact(name = "portofrotterdam",
				email = "portofrotterdam@nl.ibm.com"),
		license = @License(name = "Apache License Version 2.0", url = "LICENSE URL"), version = "1.0"))*/
public class DemoSpringGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringGatewayApplication.class, args);
	}


}
