package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.PaymentResponse;
import com.foodygo.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponse createPayment(CreatePaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResponse findById(Integer id) {
        return null;
    }

    @Override
    public List<PaymentResponse> findByUserId(Integer id) {
        return List.of();
    }

}
