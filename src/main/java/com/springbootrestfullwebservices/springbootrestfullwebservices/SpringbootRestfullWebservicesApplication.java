package com.springbootrestfullwebservices.springbootrestfullwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documention",
				description = "SpringBoot Documention",
				version = "V1.0",
				contact = @Contact(
						name = "Mohan",
						email = "Mohanrayidi@gmail.com",
						url = "http://localhost:8090/swagger-ui/index.html"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://localhost:8090/swagger-ui/index.html"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "SpringBoot User Management Documention",
				url = "http://google.com"
		)
)
public class SpringbootRestfullWebservicesApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
	}

}
