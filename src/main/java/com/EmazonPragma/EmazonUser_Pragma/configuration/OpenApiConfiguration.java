package com.EmazonPragma.EmazonUser_Pragma.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app.description}") String appDescription,
            @Value("${app.version}") String appVersion
    ) {
        return new OpenAPI().info(new Info()
                .title("Hexagonal Emazon's User Microservice API")
                .version(appVersion)
                .description(appDescription)
                .termsOfService("https://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
