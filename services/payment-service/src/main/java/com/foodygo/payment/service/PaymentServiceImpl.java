package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.PaymentResponse;
import com.foodygo.payment.entity.Payment;
import com.foodygo.payment.entity.PaymentMethod;
import com.foodygo.payment.mapper.PaymentMapper;
import com.foodygo.payment.repository.PaymentMethodRepository;
import com.foodygo.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository repo;
    private final PaymentMethodRepository methodRepo;

    @Override
    public PaymentResponse createPayment(CreatePaymentRequest request) {
        PaymentMethod method = methodRepo.findById(request.methodId()).orElseThrow();
        Payment payment = new Payment();
        payment.setAmount(request.amount());
        payment.setCustomerId(request.customerId());
        payment.setOrderId(request.orderId());
        payment.setPaymentMethod(method);
        return PaymentMapper.INSTANCE.toDto(repo.save(payment));
    }

    @Override
    public PaymentResponse findById(Integer id) {
        return PaymentMapper.INSTANCE.toDto(repo.findByIdAndIsDeletedFalse(id));
    }

    @Override
    public List<PaymentResponse> findByUserId(Integer id) {
        List<Payment> payments = repo.findByCustomerIdAndIsDeletedFalse(id);
        return payments.stream()
                .map(PaymentMapper.INSTANCE::toDto)
                .toList();
    }

}
