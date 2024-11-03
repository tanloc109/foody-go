package com.foodygo.order.service;

import com.foodygo.order.customer.CustomerClient;
import com.foodygo.order.dto.request.OrderCreateRequest;
import com.foodygo.order.dto.request.PurchaseProductRequest;
import com.foodygo.order.dto.response.OrderResponse;
import com.foodygo.order.exception.BusinessException;
import com.foodygo.order.mapper.OrderMapper;
import com.foodygo.order.orderDetail.OrderDetailRequest;
import com.foodygo.order.product.ProductClient;
import com.foodygo.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderDetailService orderDetailService;

    @Override
    public OrderResponse createOrder(OrderCreateRequest orderRequest) {
        //check customer exist
        var customer = this.customerClient.findUserById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: Customer not found with the provided id: " + orderRequest.customerId()));
        //purchase the products --> product-ms (RestTemplate)
        this.productClient.purchaseProducts(orderRequest.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(orderRequest));

        //persist order detail
        for (PurchaseProductRequest product : orderRequest.products()) {
                orderDetailService.saveOrderDetail(
                        new OrderDetailRequest(
                                order.getId(),
                                product.id(),
                                product.quantity(),
                                product.price()
                        )
                );
        }
        //continue
        return mapper.toResponse(order);
    }
}
