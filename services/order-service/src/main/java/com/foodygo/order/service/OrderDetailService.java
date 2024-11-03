package com.foodygo.order.service;

import com.foodygo.order.entity.OrderDetail;
import com.foodygo.order.orderDetail.OrderDetailRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {
    OrderDetail saveOrderDetail(OrderDetailRequest request);
}
