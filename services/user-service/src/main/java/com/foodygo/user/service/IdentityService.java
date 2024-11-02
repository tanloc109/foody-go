package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.entity.User;

public interface IdentityService {
    User registerUser(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    User updateProfile(UpdateProfileRequest request);
    boolean resetPassword(ResetPasswordRequest request);
    boolean verifyOTP(VerifyOTP otp);
    TokenResponse requestResetPassword(String token);
}
