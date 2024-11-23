package com.foodygo.user.service;

import com.foodygo.user.dto.request.*;
import com.foodygo.user.dto.response.LoginResponse;
import com.foodygo.user.dto.response.TokenResponse;
import com.foodygo.user.dto.response.UserDTO;
import com.foodygo.user.entity.Role;
import com.foodygo.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class IdentityServiceImpl implements IdentityService{

    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final SmsService smsService;
    private final Map<String, String> otpStorage = new HashMap<>();

    @Override
    public UserDTO registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setFullname(request.getFullname());
        List<Role> roles = new ArrayList<>();
        for (Integer id: request.getRoleIds()) {
            Role tempRole = roleService.findEntityById(id);
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
        User user = userService.findEntityByUsername(request.getUsername());
        if(user == null) return null;
        if(!user.getPassword().equals(request.getPassword())) return null;
        LoginResponse response = LoginResponse.builder()
                                    .token(jwtService.generateToken(user))
                                    .username(user.getUsername())
                                .build();
        return response;
    }

    @Override
    public boolean resetPassword(ResetPasswordRequest request) {
        if (!jwtService.isTokenExpired(request.getToken())) {
            String username = jwtService.extractUsername(request.getToken());
            if (request.getPassword().equals(request.getConfirmPassword())) {
                User user = userService.findEntityByUsername(username);
                user.setPassword(request.getPassword());
                userService.save(user);
            }
        }
        return false;
    }

    @Override
    public TokenResponse verifyOTP(VerifyOTP otp) {
        TokenResponse result = new TokenResponse();
        String phoneNumber = otp.getPhone();
        String storedOtp = otpStorage.get(phoneNumber);
        if (storedOtp != null && storedOtp.equals(otp.getOtp())) {
            otpStorage.remove(phoneNumber);
            User user = userService.findEntityByPhone(phoneNumber);
            result.setToken(jwtService.generateToken(user));
        }
        return result;
    }

    @Override
    public Object forgetPasswordRequest(ForgetPasswordRequest request) {
        String formattedPhone = formatPhoneNumber(request.getPhone());
        String otp = smsService.generateOtp();
        otpStorage.put(request.getPhone(), otp);
        smsService.sendOtp(formattedPhone, otp);
        return null;
    }

    private String formatPhoneNumber(String phoneNumber) {
        // Example logic for Vietnamese numbers
        if (phoneNumber.startsWith("0")) {
            // Replace leading '0' with '+84' (Vietnam country code)
            return "+84" + phoneNumber.substring(1);
        }
        if (!phoneNumber.startsWith("+")) {
            throw new IllegalArgumentException("Phone number must include country code.");
        }
        return phoneNumber;
    }
}
