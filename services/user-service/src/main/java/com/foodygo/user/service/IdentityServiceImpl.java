package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService{

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public User registerUser(RegisterRequest request) {
        return null;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public User updateProfile(UpdateProfileRequest request) {
        return null;
    }

    @Override
    public boolean resetPassword(ResetPasswordRequest request) {
        return false;
    }

    @Override
    public boolean verifyOTP(VerifyOTP otp) {
        return false;
    }

    @Override
    public TokenResponse requestResetPassword(String token) {
        return null;
    }
}
