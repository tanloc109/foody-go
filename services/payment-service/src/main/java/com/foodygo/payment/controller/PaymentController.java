package com.foodygo.payment.controller;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.ApiResponse;
import com.foodygo.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/payments"))
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<ApiResponse<Object>> createPayment(@RequestBody CreatePaymentRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Register user success")
                        .data(paymentService.createPayment(request))
                        .build()
        );
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse<Object>> getPaymentsOfUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get payments of user: " + " success")
                        .data(paymentService.findByUserId(userId))
                        .build()
        );
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<ApiResponse<Object>> getPaymentById(@PathVariable Integer paymentId) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get payment: " + " success")
                        .data(paymentService.findById(paymentId))
                        .build()
        );
    }

}
