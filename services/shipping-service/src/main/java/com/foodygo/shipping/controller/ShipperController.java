package com.foodygo.shipping.controller;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ApiResponse;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.dto.response.ShipperResponse;
import com.foodygo.shipping.service.ShipperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shipping/shipper")
@RequiredArgsConstructor
@Validated
public class ShipperController {

    private final ShipperService shipperService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ShipperCreationUpdateResponse>> createShipper(
            @RequestBody ShipperCreationRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.<ShipperCreationUpdateResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Created shipper")
                                .data(shipperService.createShipper(request))
                                .build()
                );
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ShipperResponse>>> getAllActiveShippers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<List<ShipperResponse>>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Created shipper")
                                .data(shipperService.getAllActiveShipper())
                                .build()
                );
    }

    @GetMapping("/{shipperId}")
    public ResponseEntity<ApiResponse<ShipperResponse>> getActiveShipper(@PathVariable Integer shipperId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShipperResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Shipper " + shipperId)
                                .data(shipperService.getActiveShipper(shipperId))
                                .build()
                );
    }

    @PutMapping("/{shipperId}/update")
    public ResponseEntity<ApiResponse<ShipperCreationUpdateResponse>> updateShipper(
            @PathVariable Integer shipperId,
            @RequestBody ShipperUpdateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShipperCreationUpdateResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Update shipper")
                                .data(shipperService.updateShipper(shipperId, request))
                                .build()
                );
    }

    @DeleteMapping("/{shipperId}/delete")
    public ResponseEntity<ApiResponse<Void>> deleteShipper(@PathVariable Integer shipperId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<Void>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Deleted shipper")
                                .build()
                );
    }
}
