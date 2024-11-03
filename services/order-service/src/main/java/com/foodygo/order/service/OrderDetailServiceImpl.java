package com.foodygo.order.service;

import com.foodygo.order.entity.OrderDetail;
import com.foodygo.order.mapper.OrderDetailMapper;
import com.foodygo.order.orderDetail.OrderDetailRequest;
import com.foodygo.order.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper mapper;

    @Override
    public OrderDetail saveOrderDetail(OrderDetailRequest request) {
        return orderDetailRepository.save(mapper.toEntity(request));
    }
}
