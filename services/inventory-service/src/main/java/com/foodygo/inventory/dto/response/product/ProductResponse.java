package com.foodygo.inventory.dto.response.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Integer quantity;
    Integer branchId;
    Integer productGroupId;
    Instant createdAt;
    String createdBy;
    Instant modifiedAt;
    String modifiedBy;
}
