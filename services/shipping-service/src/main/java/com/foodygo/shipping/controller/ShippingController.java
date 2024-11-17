package com.foodygo.shipping.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingController {

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("HELLO");
    }

}
