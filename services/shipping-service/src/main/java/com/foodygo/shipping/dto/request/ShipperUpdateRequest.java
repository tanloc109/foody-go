package com.foodygo.shipping.dto.request;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import lombok.Builder;

@Builder
public record ShipperUpdateRequest(
        String citizenId,
        String photo,
        String photoModel,
        String licensePlate,
        String driverLicenseId,
        String driverLicensePhoto,
        ShipperStatus status
) {
}
