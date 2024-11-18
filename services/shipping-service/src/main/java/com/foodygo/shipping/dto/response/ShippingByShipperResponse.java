package com.foodygo.shipping.dto.response;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import lombok.Builder;

import java.util.List;

public record ShippingByShipperResponse(
        Shipper shipper
) {
    @Builder
    public record Shipper(
            Integer shipperId,
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
                Integer shippingId,
                Double distance,
                Double fee,
                Integer orderId,
                ShippingByBranchResponse.Branch.Shipping.Shipper shipper
        ) {
        }
    }
}
