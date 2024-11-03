package com.foodygo.order.product;

public record PurchaseProductResponse(
        Integer id,
        String name,
        String description,
        double price
) {
}
