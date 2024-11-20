package com.foodygo.shipping.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    Instant timestamp;
    Boolean success;
    String message;
    Integer errorCode;
    T data;
}
