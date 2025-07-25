package com.sudha.PartTimeJobs.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Part Time Jobs API")
                        .description("Backend APIs for managing part-time job listings, users, and services")
                        .version("1.0.0"));
    }
}
