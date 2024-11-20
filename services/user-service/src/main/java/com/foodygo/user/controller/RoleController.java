package com.foodygo.user.controller;

import com.foodygo.user.dto.request.CreateRoleRequest;
import com.foodygo.user.dto.request.UpdateRoleRequest;
import com.foodygo.user.dto.response.ApiResponse;
import com.foodygo.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllRole() {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get all role success")
                        .data(roleService.findAll())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> getRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Get role " + id + " success")
                        .data(roleService.findById(id))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> updateRole(@RequestBody CreateRoleRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Created new role")
                        .data(roleService.create(request))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> updateRole(@PathVariable Integer id, UpdateRoleRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Update role " + id + " success")
                        .data(roleService.update(id, request))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteRole(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Deleted role " + id + " success")
                        .data(roleService.delete(id))
                        .build()
        );
    }

}
