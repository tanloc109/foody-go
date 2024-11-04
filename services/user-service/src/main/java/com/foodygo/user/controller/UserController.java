package com.foodygo.user.controller;

import com.foodygo.user.dto.request.UpdateProfileRequest;
import com.foodygo.user.dto.response.ApiResponse;
import com.foodygo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllUser() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get all users success")
                        .data(userService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get user " + id + " success")
                        .data(userService.findById(id))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> updateUser(@PathVariable Integer id, @RequestBody UpdateProfileRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Update profile " + id + " success")
                        .data(userService.updateProfile(id, request))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Deleted profile " + id + " success")
                        .data(userService.delete(id))
                        .build()
        );
    }
}
