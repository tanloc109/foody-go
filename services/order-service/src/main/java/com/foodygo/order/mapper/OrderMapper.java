package com.foodygo.order.mapper;

import com.foodygo.order.dto.request.OrderCreateRequest;
import com.foodygo.order.dto.response.OrderResponse;
import com.foodygo.order.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OrderMapper {
    OrderResponse toResponse(Order order);
    Order toOrder(OrderCreateRequest request);
}
