package com.foodygo.payment.dto.response;

import lombok.Builder;

import java.time.Instant;

@Builder
public record PaymentResponse (
        Integer id,
        Double amount,
        Integer customerId,
        Integer orderId,
        Instant datetime,
        PaymentMethod paymentMethod
) {
    public static record PaymentMethod(
            Integer id,
            String name
    ) {}
}
