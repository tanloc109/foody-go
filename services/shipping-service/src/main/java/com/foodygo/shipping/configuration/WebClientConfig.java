package com.foodygo.shipping.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${api.service.location}")
    private String locationServiceURL;

    @Value("${api.service.order}")
    private String orderServiceURL;

    @Value("${api.service.notification}")
    private String notificationServiceURL;

    @Bean
    public WebClient locationWebClient() {
        return WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .baseUrl(locationServiceURL)
                .build();
    }

    @Bean
    public WebClient orderWebClient() {
        return WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .baseUrl(orderServiceURL)
                .build();
    }

    @Bean
    public WebClient notificationWebClient() {
        return WebClient.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(10 * 1024 * 1024))
                .baseUrl(notificationServiceURL)
                .build();
    }
}
