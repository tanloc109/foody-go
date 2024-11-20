package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.entity.User;

public interface IdentityService {
    User registerUser(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    boolean resetPassword(String token, ResetPasswordRequest request);
    TokenResponse verifyOTP(VerifyOTP otp);
    Object forgetPasswordRequest(ForgetPasswordRequest request);
}
