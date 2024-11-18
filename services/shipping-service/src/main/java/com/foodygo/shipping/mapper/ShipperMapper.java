package com.foodygo.shipping.mapper;

import com.foodygo.shipping.dto.response.ShippingByShipperResponse;
import com.foodygo.shipping.entity.Shipper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShipperMapper {
    ShipperMapper INSTANCE = Mappers.getMapper(ShipperMapper.class);

    ShippingByShipperResponse.Shipper toDTO(Shipper shipper);
}
