package com.foodygo.shipping.controller;

import com.foodygo.shipping.dto.response.ApiResponse;
import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.service.ShippingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/shipping")
@RequiredArgsConstructor
@Validated
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

    @PostMapping("/orders/{orderId}/{status}")
    public ResponseEntity<ApiResponse<Object>> acceptOrReject(
            @PathVariable Integer orderId,
            @PathVariable @Valid @Pattern(regexp = "accept|reject", message = "Status must be 'accept' or 'reject'") String status
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<Object>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .data(null)
                                .message("Order " + orderId + " has been " + status + "ed")
                                .build()
                );
    }

    @PostMapping("/calculate-fee")
    public ResponseEntity<ApiResponse<Object>> calculateShippingCosts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<Object>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .data(null)
                                .message("Calculate fee")
                                .build()
                );
    }
}
