package com.foodygo.shipping.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ShippingCreationRequest(
        @NotNull(message = "Order ID cannot be null")
        Integer orderId,
        @NotNull(message = "Customer ID cannot be null")
        Integer customerId,
        @NotNull(message = "Branch ID cannot be null")
        Integer branchId
) {
}
