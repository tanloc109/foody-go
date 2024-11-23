package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.dto.response.ShipperResponse;
import com.foodygo.shipping.entity.Shipper;

import java.util.List;

public interface ShipperService extends BaseService<Shipper, Integer> {
    ShipperCreationUpdateResponse createShipper(ShipperCreationRequest request);
    ShipperCreationUpdateResponse updateShipper(Integer shipperId, ShipperUpdateRequest request);
    List<ShipperResponse> getAllActiveShipper();
    ShipperResponse getActiveShipper(Integer shipperId);
    void deleteShipper(Integer shipperId);
}
