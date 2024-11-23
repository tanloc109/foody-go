package com.foodygo.payment.vnpay;

import com.foodygo.payment.dto.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vnpay")
@RequiredArgsConstructor
public class PaymentControllerA {

    private final PaymentService paymentService;

    @GetMapping("/vn-pay")
    public ResponseEntity<ApiResponse<Object>> pay(HttpServletRequest request) {
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .success(true)
                        .message("Success")
                        .data(paymentService.createVnPayPayment(request))
                        .build()
        );
    }

    @GetMapping("/vn-pay-callback")
    public ResponseEntity<ApiResponse<Object>> payCallbackHandler(HttpServletRequest request) {
        String status = request.getParameter("vnp_ResponseCode");
        if ("00".equals(status)) {
            return ResponseEntity.ok(
                    ApiResponse.builder()
                            .success(true)
                            .message("Callback success")
                            .data(null)
                            .build()
            );
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(
                            ApiResponse.builder()
                                    .success(false)
                                    .message("Callback failed with status: " + status)
                                    .data(null)
                                    .build()
                    );
        }
    }

}
