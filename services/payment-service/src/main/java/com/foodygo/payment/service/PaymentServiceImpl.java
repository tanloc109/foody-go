package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.CreatePaymentResposne;
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
    public List<PaymentResponse> findAll() {
        return List.of();
    }

    @Override
    public List<PaymentResponse> findByUserId(Integer id) {
        return List.of();
    }

    @Override
    public PaymentResponse findById(Integer id) {
        return null;
    }

    @Override
    public PaymentResponse findByOrderId(Integer id) {
        return null;
    }

    @Override
    public CreatePaymentResposne createPayment(CreatePaymentRequest request) {
        return null;
    }

    @Override
    public Object deletePayment(Integer id) {
        return null;
    }
}
