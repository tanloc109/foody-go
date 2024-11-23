package com.foodygo.location.mapper;

import com.foodygo.location.dto.response.ProvinceResponseDTO;
import com.foodygo.location.entities.Province;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProvinceMapper {
    ProvinceMapper INSTANCE = Mappers.getMapper(ProvinceMapper.class);
    ProvinceResponseDTO toDTO(Province province);
}
