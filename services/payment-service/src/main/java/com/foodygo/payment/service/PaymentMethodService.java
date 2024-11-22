package com.foodygo.payment.service;

import com.foodygo.payment.dto.request.MethodCreateRequest;
import com.foodygo.payment.dto.response.MethodResponse;
import com.foodygo.payment.dto.response.MethodUpdateRequest;

import java.util.List;

public interface PaymentMethodService {
    List<MethodResponse> findAll();
    MethodResponse create(MethodCreateRequest request);
    MethodResponse updater(MethodUpdateRequest request);
    Object delete(Integer id);
}
