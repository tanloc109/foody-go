package com.foodygo.shipping.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shipper-log")
@RequiredArgsConstructor
@Validated
public class ShipperLogController {
}
