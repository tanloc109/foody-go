package com.foodygo.user.controller;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.ApiResponse;
import com.foodygo.user.service.IdentityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/identity")
public class IdentityController {

    private final IdentityService identityService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Object>> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Register user success")
                        .data(identityService.registerUser(request))
                        .build()
        );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Object>> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Login success")
                        .data(identityService.login(request))
                        .build()
        );
    }

    @GetMapping("/forget-password")
    public ResponseEntity<ApiResponse<Object>> forgetPasswordRequest(@RequestBody ForgetPasswordRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Request verify otp success")
                        .data(identityService.forgetPasswordRequest(request))
                        .build()
        );
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ApiResponse<Object>> verifyOtp(@RequestBody VerifyOTP request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Verify otp success")
                        .data(identityService.verifyOTP(request))
                        .build()
        );
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<Object>> resetPassword(@RequestBody ResetPasswordRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Reset password success")
                        .data(identityService.resetPassword("",request))
                        .build()
        );
    }


}
