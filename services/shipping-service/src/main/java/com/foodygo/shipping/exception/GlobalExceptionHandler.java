package com.foodygo.shipping.exception;

import com.foodygo.shipping.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleIdNotFoundException(IdNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<String>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Id not found: " + e.getMessage())
                                .errorCode(HttpStatus.NOT_FOUND.value())
                                .build()
                );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.<String>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Internal Server Error: " + e.getMessage())
                                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .build()
                );
    }
}
