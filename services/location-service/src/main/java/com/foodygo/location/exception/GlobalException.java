package com.foodygo.location.exception;

import com.foodygo.location.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleIdNotFoundException(IdNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.builder()
                        .success(false)
                        .message(ex.getMessage())
                        .errorCode(HttpStatus.BAD_REQUEST.value())
                        .build());
    }
}
