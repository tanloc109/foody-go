package com.foodygo.shipping.dto.request;

import lombok.Builder;

@Builder
public record ShipperCreationRequest(
        String citizenId,
        String photo,
        String motoModel,
        String licensePlate,
        String driverLicenseId,
        String driverLicensePhoto
        ) {
}
