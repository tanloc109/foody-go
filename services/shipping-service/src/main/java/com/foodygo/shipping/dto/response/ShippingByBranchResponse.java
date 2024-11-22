package com.foodygo.shipping.dto.response;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import lombok.Builder;

import java.util.List;

@Builder
public record ShippingByBranchResponse(
        Branch branch
) {
    @Builder
    public record Branch(
            Integer branchId,
            String branchName,
            List<Shipping> shippings
    ) {
        @Builder
        public record Shipping(
                Integer id,
                Double distance,
                Double fee,
                Integer orderId,
                Shipper shipper
        ) {
            @Builder
            public record Shipper(
                    Integer id,
                    String citizenId,
                    String photo,
                    String motoModel,
                    String licensePlate,
                    String driverLicenseId,
                    String driverLicensePhoto,
                    Boolean available,
                    ShipperStatus status
            ) {
            }
        }
    }
}
