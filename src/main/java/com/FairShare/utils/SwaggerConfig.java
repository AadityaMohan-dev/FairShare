package com.FairShare.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI expenseTrackerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("FairShare API")
                        .description("API documentation for the FairShare application")
                        .version("1.0"));
    }
}