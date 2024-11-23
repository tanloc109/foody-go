package com.foodygo.shipping.dto.response;

import com.foodygo.shipping.entity.enums.ShipperStatus;
import lombok.Builder;

@Builder
public record ShipperCreationUpdateResponse(
        Integer id,
        String citizenId,
        String photo,
        String motoModel,
        String licensePlate,
        String driverLicenseId,
        String driverLicensePhoto,
        ShipperStatus status
) {
}
