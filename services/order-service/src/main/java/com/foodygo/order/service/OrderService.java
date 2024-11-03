package com.foodygo.order.service;

import com.foodygo.order.dto.request.OrderCreateRequest;
import com.foodygo.order.dto.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    OrderResponse createOrder(OrderCreateRequest order);
}
