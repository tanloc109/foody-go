package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.CreatePaymentResposne;
import com.foodygo.payment.dto.response.PaymentResponse;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> findAll();
    List<PaymentResponse> findByUserId(Integer id);
    PaymentResponse findById(Integer id);
    PaymentResponse findByOrderId(Integer id);
    CreatePaymentResposne createPayment(CreatePaymentRequest request);
    Object deletePayment(Integer id);
}
