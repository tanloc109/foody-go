package com.foodygo.inventory.mapper;

import com.foodygo.inventory.dto.request.product.ProductCreateRequest;
import com.foodygo.inventory.dto.request.product.ProductUpdateRequest;
import com.foodygo.inventory.dto.response.product.ProductCreateResponse;
import com.foodygo.inventory.dto.response.product.ProductResponse;
import com.foodygo.inventory.dto.response.product.ProductUpdateResponse;
import com.foodygo.inventory.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product toCreateEntity(ProductCreateRequest request);
    Product toUpdateEntity(ProductUpdateRequest request);
    ProductCreateResponse toCreateResponse(Product product);
    ProductUpdateResponse toUpdateResponse(Product product);
    ProductResponse toResponse(Product product);
}
