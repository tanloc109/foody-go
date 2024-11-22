package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse createPayment(CreatePaymentRequest request);
    PaymentResponse findById(Integer id);
    List<PaymentResponse> findByUserId(Integer id);
}
