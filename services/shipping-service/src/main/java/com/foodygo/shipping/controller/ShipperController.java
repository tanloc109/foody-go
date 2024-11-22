package com.foodygo.shipping.controller;

import com.foodygo.shipping.dto.request.ShipperCreationRequest;
import com.foodygo.shipping.dto.request.ShipperUpdateRequest;
import com.foodygo.shipping.dto.response.ApiResponse;
import com.foodygo.shipping.dto.response.ShipperCreationUpdateResponse;
import com.foodygo.shipping.service.ShipperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/shipper")
@RequiredArgsConstructor
@Validated
public class ShipperController {

    private final ShipperService shipperService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ShipperCreationUpdateResponse>> createShipper(
            @RequestBody ShipperCreationRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShipperCreationUpdateResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Created shipper")
                                .data(shipperService.createShipper(request))
                                .build()
                );
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<ShipperCreationUpdateResponse>> updateShipper(
            @RequestBody ShipperUpdateRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<ShipperCreationUpdateResponse>builder()
                                .timestamp(Instant.now())
                                .success(true)
                                .message("Update shipper")
                                .data(shipperService.updateShipper(request))
                                .build()
                );
    }
}
