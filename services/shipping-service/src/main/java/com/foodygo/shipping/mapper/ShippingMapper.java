package com.foodygo.shipping.mapper;

import com.foodygo.shipping.dto.response.ShippingByBranchResponse;
import com.foodygo.shipping.dto.response.ShippingCreationResponse;
import com.foodygo.shipping.entity.Shipping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShippingMapper {
    ShippingMapper INSTANCE = Mappers.getMapper(ShippingMapper.class);

    ShippingByBranchResponse.Branch.Shipping toDTO(Shipping shipping);
    ShippingCreationResponse toCreateDTO(Shipping shipping);
}
