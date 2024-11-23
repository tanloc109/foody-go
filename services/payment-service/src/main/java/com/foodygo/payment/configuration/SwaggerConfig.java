package com.foodygo.payment.configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Pham Tan Loc
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Foody-Go Delivery Payment Service"))
                .addSecurityItem(new SecurityRequirement().addList("Foody-Go Authentication Service"))
                .components(new Components().addSecuritySchemes("Foody-Go Authentication Service", new SecurityScheme()
                        .name("Foody-Go - Payment Service").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
