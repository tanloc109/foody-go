package com.foodygo.order.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "user-service",
        url = "${application.config.user-url}"
)
public interface CustomerClient {
    @GetMapping("/{user-id}")
    Optional<CustomerResponse> findUserById(@PathVariable("user-id") Integer userId);
}
