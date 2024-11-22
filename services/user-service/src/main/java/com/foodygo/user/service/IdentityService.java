package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.dto.response.UserDTO;

public interface IdentityService {
    UserDTO registerUser(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    boolean resetPassword(ResetPasswordRequest request);
    TokenResponse verifyOTP(VerifyOTP otp);
    Object forgetPasswordRequest(ForgetPasswordRequest request);
}
