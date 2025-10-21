package net.javaguides.banking;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.webmvc.api.OpenApiActuatorResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
		System.out.println("Banking Application has been Started...");
	}

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info()
                .title("Swagger Banking APP")
                .version("1.0")
                .description("Customization of Banking Swagger Open API"));
    }
}
