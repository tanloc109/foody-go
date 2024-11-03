package com.foodygo.order.dto.request;

import com.foodygo.order.util.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderCreateRequest(

    @NotNull(message = "Order status should be precised")
    OrderStatus status,

    @NotNull(message = "Customer should be present")
    Integer customerId,

    @NotNull(message = "Shipper should be present")
    Integer shipperId,

    @NotNull(message = "Payment should be present")
    Integer paymentId,

    @NotEmpty(message = "At least purchase one product")
    List<PurchaseProductRequest> products
){

}
