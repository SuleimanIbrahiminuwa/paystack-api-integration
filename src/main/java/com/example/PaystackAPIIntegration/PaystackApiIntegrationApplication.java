package com.example.PaystackAPIIntegration;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "PAY_STACK TRANSACTION APPLICATION",
				description = "BACKEND REST APIs",
				version = "v1.0",
				contact = @Contact(
						name = "Suleiman Ibrahim Inuwa",
						email = "isuleimanibrahim@gmail.com",
						url = "https://github.com/SuleimanIbrahiminuwa/paystack-api-integration"
				),
				license = @License(
						name = "Suleiman Ibrahim Software Developer",
						url = "https://github.com/SuleimanIbrahiminuwa/paystack-api-integration"
				)


		),
		externalDocs = @ExternalDocumentation(
				description = "PAY_STACK TRANSACTION APPLICATION DOCUMENTATION",
				url = "https://github.com/SuleimanIbrahiminuwa/paystack-api-integration"
		)
)
public class PaystackApiIntegrationApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaystackApiIntegrationApplication.class, args);
	}

}
