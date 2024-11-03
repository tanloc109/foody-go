package com.foodygo.order.orderDetail;

public record OrderDetailRequest(
        Integer orderId,
        Integer productId,
        Integer quantity,
        double price
) {

}
