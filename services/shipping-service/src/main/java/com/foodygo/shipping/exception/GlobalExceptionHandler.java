package com.foodygo.shipping.exception;

import com.foodygo.shipping.dto.response.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<Map<String, String>>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Validation error")
                                .data(errors)
                                .errorCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<Map<String, String>>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Validation error")
                                .data(errors)
                                .errorCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<String>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Invalid argument: " + e.getMessage())
                                .errorCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                );
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleIdNotFoundException(IdNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<String>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Id not found: " + e.getMessage())
                                .errorCode(HttpStatus.BAD_REQUEST.value())
                                .build()
                );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiResponse<String>> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.<String>builder()
                                .timestamp(Instant.now())
                                .success(false)
                                .message("Already exists: " + e.getMessage())
                                .errorCode(HttpStatus.BAD_REQUEST.value())
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
