package com.foodygo.payment.mapper;

import com.foodygo.payment.dto.request.CreatePaymentRequest;
import com.foodygo.payment.dto.response.PaymentResponse;
import com.foodygo.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentResponse toDto(Payment payment);

    Payment toEntity(CreatePaymentRequest dto);
}
