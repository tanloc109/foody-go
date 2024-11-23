package com.foodygo.shipping.dto.response;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import com.foodygo.shipping.entity.enums.ShippingStatus;
import lombok.Builder;

import java.util.List;

@Builder
public record ShipperResponse(
        Integer id,
        String citizenId,
        String photo,
        String motoModel,
        String licensePlate,
        String driverLicenseId,
        String driverLicensePhoto,
        Boolean available,
        ShipperStatus status,
        List<Shipping> shippings
        ) {
    @Builder
    public record Shipping(
            Integer id,
            Double distance,
            Double fee,
            Integer orderId,
            Integer branchId,
            Integer customerId,
            ShippingStatus status
    ) {

    }
}
