package com.foodygo.order.controller;

import com.foodygo.order.dto.request.OrderCreateRequest;
import com.foodygo.order.dto.response.ApiResponse;
import com.foodygo.order.dto.response.OrderResponse;
import com.foodygo.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody @Valid OrderCreateRequest orderRequestDTO) {
        return ResponseEntity.ok(ApiResponse.<OrderResponse>builder()
                        .message("Successfully created order")
                        .data(orderService.createOrder(orderRequestDTO))
                        .status(HttpStatus.CREATED.value())
                .build());
    }
}
