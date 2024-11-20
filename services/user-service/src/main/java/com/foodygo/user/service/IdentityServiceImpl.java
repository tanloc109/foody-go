package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.entity.Role;
import com.foodygo.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService{

    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;

    @Override
    public User registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setFullname(request.getFullname());
        List<Role> roles = new ArrayList<>();
        for (Integer id: request.getRoleIds()) {
            Role tempRole = roleService.findById(id);
            if (tempRole != null) {
                roles.add(tempRole);
                tempRole.getUsers().add(user);
            }
        }
        user.setRoles(roles);
        return userService.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userService.findByUsername(request.getUsername());
        if(user == null) return null;
        if(!user.getPassword().equals(request.getPassword())) return null;
        LoginResponse response = LoginResponse.builder()
                                    .token(jwtService.generateToken(user))
                                    .username(user.getUsername())
                                .build();
        return response;
    }

    @Override
    public boolean resetPassword(String token, ResetPasswordRequest request) {

        return false;
    }

    @Override
    public TokenResponse verifyOTP(VerifyOTP otp) {
        return null;
    }

    @Override
    public Object forgetPasswordRequest(ForgetPasswordRequest request) {

        return null;
    }
}
