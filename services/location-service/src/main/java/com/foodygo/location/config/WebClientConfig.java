package com.foodygo.location.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

        @Value("${location.api.base-url}")
        private String baseURL;

        @Bean
        public WebClient webClient() {
            return WebClient.builder().codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024)).baseUrl(baseURL).build();
        }

}
