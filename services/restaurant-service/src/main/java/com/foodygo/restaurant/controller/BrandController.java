package com.foodygo.restaurant.controller;

import com.foodygo.restaurant.dto.request.CreateBrandRequest;
import com.foodygo.restaurant.dto.request.UpdateBrandRequest;
import com.foodygo.restaurant.dto.response.ApiResponse;
import com.foodygo.restaurant.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllBrand() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get all brand success")
                        .data(brandService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getBrand(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get all brand success")
                        .data(brandService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createBrand(@RequestBody CreateBrandRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Create brand success")
                        .data(brandService.createBrand(request))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getBrand(@PathVariable Integer id, @RequestBody UpdateBrandRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get all brand success")
                        .data(brandService.update(id, request))
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deteleBrand(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Delete brand success")
                        .data(brandService.delete(id))
                        .build()
        );
    }


}
