package com.foodygo.inventory.dto.request.product;

import com.foodygo.inventory.util.constant.ProductStatus;
import jakarta.validation.constraints.NotNull;
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
public class ProductCreateRequest {
    @NotNull(message = "Quantity is required!")
    Integer quantity;
    @NotNull(message = "Branch Id is required!")
    Integer branchId;
    @NotNull(message = "Product status is required!")
    ProductStatus productStatus;
    @NotNull(message = "Product group id is required!")
    Integer productGroupId;
}
