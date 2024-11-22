package com.foodygo.shipping.service;

import com.foodygo.shipping.dto.request.ShippingCreationRequest;
import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.dto.response.ShippingCreationResponse;
import com.foodygo.shipping.entity.Shipping;

import java.util.List;

public interface ShippingService extends BaseService<Shipping, Integer> {
    List<Shipping> findByBranchId(Integer branchId);
    Shipping findByOrderId(Integer orderId);
    ShippingByShipperResponse getShippingsByShipperId(Integer shipperId);
    ShippingByBranchResponse getShippingsByBranchId(Integer branchId);
    ShippingCreationResponse createShipping(ShippingCreationRequest request);
    Double calculateFee(Double distance);
}
