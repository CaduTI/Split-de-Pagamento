package br.com.sps.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig{
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
				.title("Swift Pay - Split Payments")
				.version("V1")
				.description("A simple API with Java and Spring Boot")
				.termsOfService("https://github.com/CaduTI")
				.license(new License()
						.name("Apache 2.0")
						.url("https://github.com/CaduTI")
				)
				);
				
	}
}