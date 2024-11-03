package com.foodygo.order.dto.response;

import com.foodygo.order.entity.OrderDetail;
import com.foodygo.order.util.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record OrderResponse (
        Integer id,
        BigDecimal shippingCost,
        BigDecimal serviceCost,
        BigDecimal totalCost,
        Integer shipperId,
        Integer customerId,
        Integer paymentId,
        OrderStatus status,
        Instant createdAt,
        Instant lastModifiedAt
){

}
