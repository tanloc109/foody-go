package com.foodygo.order.mapper;

import com.foodygo.order.entity.OrderDetail;
import com.foodygo.order.orderDetail.OrderDetailRequest;
import com.foodygo.order.orderDetail.OrderDetailResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface OrderDetailMapper {
    OrderDetailResponse toResponse(OrderDetail orderDetail);
    OrderDetail toEntity(OrderDetailRequest request);
}
