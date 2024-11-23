package com.foodygo.shipping.controller;

import com.foodygo.shipping.service.ShipperLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shipping/logs")
@RequiredArgsConstructor
@Validated
public class ShipperLogController {

    private final ShipperLogService shipperLogService;

}
