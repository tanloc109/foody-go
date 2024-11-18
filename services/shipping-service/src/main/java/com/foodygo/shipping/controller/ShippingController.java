package com.foodygo.shipping.controller;

import com.foodygo.shipping.dto.response.ApiResponse;
import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/shipping")
@RequiredArgsConstructor
public class ShippingController {

    private final ShippingService shippingService;

    @GetMapping("/shipper/{shipperId}/orders")
    public ResponseEntity<ApiResponse<ShippingByShipperResponse>> getAllShippingsOfShipper(@PathVariable Integer shipperId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShippingByShipperResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Get all orders of shipper " + shipperId)
                                .data(shippingService.getShippingsByShipperId(shipperId))
                                .build()
                );
    }

    @GetMapping("/branch/{branchId}/orders")
    public ResponseEntity<ApiResponse<ShippingByBranchResponse>> getAllShippingsOfBranch(@PathVariable Integer branchId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShippingByBranchResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Get all orders of branch " + branchId)
                                .data(shippingService.getShippingsByBranchId(branchId))
                                .build()
                );
    }


}
