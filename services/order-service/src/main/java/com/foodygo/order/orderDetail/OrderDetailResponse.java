package com.foodygo.order.orderDetail;

public record OrderDetailResponse (
        Integer id,
        Integer productId,
        Integer orderId,
        Integer quantity,
        double price
) {
}
