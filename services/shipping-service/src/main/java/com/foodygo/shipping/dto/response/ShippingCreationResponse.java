package com.foodygo.shipping.dto.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record ShippingCreationResponse(
        Integer id,
        Integer orderId,
        Integer branchId,
        Integer customerId,
        Double distance,
        Double fee,
        Instant created
) {
}
