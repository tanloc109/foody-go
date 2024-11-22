package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.entity.Shipper;

public interface ShipperService extends BaseService<Shipper, Integer> {
    ShipperCreationUpdateResponse createShipper(ShipperCreationRequest request);
    ShipperCreationUpdateResponse updateShipper(ShipperUpdateRequest request);
}
