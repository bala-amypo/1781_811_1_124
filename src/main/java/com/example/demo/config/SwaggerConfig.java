package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "BearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                
                .servers(List.of(
                        new Server()
                                .url("https://9374.pro604cr.amypo.ai/")
                                .description("Production Server")
                ))

                
                .info(new Info()
                        .title("Supplier Diversity Tracker API")
                        .description("REST API documentation for Supplier Diversity Tracker Spring Boot application")
                        .version("1.0")
                )

                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))

                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes(
                                SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name("Authorization")
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                );
    }
}
