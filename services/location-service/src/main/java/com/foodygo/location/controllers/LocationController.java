package com.foodygo.location.controllers;

import com.foodygo.location.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/init")
    public ResponseEntity<String> initData() {
        locationService.initLocation();
        return ResponseEntity.ok("Lấy dữ liệu địa chỉ ngon rồi đó :3");
    }
}
