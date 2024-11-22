package com.foodygo.payment.dto.request;

import lombok.Builder;

@Builder
public record CreatePaymentRequest(
        Double amount,
        Integer customerId,
        Integer orderId,
        Integer methodId
) {}
