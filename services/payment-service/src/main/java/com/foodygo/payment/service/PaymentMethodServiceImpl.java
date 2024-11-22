package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.MethodCreateRequest;
import com.foodygo.payment.dto.response.MethodResponse;
import com.foodygo.payment.dto.response.MethodUpdateRequest;
import com.foodygo.payment.repository.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService{

    private final PaymentMethodRepository paymentMethodRepository;


    @Override
    public List<MethodResponse> findAll() {
        return List.of();
    }

    @Override
    public MethodResponse create(MethodCreateRequest request) {
        return null;
    }

    @Override
    public MethodResponse updater(MethodUpdateRequest request) {
        return null;
    }

    @Override
    public Object delete(Integer id) {
        return null;
    }
}
