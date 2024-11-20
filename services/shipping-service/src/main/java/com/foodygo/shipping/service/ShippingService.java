package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.entity.Shipping;

public interface ShippingService extends BaseService<Shipping, Integer> {
    ShippingByShipperResponse getShippingsByShipperId(Integer shipperId);
    ShippingByBranchResponse getShippingsByBranchId(Integer branchId);
}
