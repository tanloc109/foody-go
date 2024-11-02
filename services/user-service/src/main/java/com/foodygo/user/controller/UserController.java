package com.foodygo.user.controller;

import com.foodygo.user.dto.request.RegisterRequest;
import com.foodygo.user.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> register(@RequestBody RegisterRequest request) {
//        String token = JwtTokenFilter.getCurrentToken();
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("")
                        .data(null)
                        .errorCode(null)
                        .build()
        );
    }
}
