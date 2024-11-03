package com.foodygo.order.product;

import com.foodygo.order.dto.request.PurchaseProductRequest;
import com.foodygo.order.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    @Value("${application.config.product-url}")
    private String productUrl;

    private final RestTemplate restTemplate;

    public List<PurchaseProductResponse> purchaseProducts(List<PurchaseProductRequest> requests) {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<List<PurchaseProductRequest>> requestEntity = new HttpEntity<>(requests, headers);
        ParameterizedTypeReference<List<PurchaseProductResponse>> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<List<PurchaseProductResponse>> responseEntity = restTemplate.exchange(
                productUrl + "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType

        );
        if(responseEntity.getStatusCode().isError()) {
            throw new BusinessException("An error occurred while processing the products purchase: " + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
