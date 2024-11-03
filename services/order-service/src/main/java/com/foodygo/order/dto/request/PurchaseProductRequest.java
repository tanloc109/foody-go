package com.foodygo.order.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record PurchaseProductRequest (

        @NotNull(message = "Product is mandatory")
        Integer id,

        @Positive(message = "Price must be positive")
        double price,

        @Positive(message = "Quantity must be positive")
        Integer quantity
){
}
