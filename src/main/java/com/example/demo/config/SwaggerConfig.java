package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                // ⚠️ Server URL NOT CHANGED as requested
                .servers(List.of(
                        new Server()
                                .url("https://9374.pro604cr.amypo.ai/")
                                .description("Production Server")
                ))
                .info(new Info()
                        .title("Supplier Diversity Tracker API")
                        .description("REST API documentation for Supplier Diversity Tracker Spring Boot application")
                        .version("1.0"));
    }
}
