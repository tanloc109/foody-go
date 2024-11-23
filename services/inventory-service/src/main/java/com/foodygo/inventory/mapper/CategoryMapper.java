package com.foodygo.inventory.mapper;

import com.foodygo.inventory.dto.request.category.CategoryCreateRequest;
import com.foodygo.inventory.dto.request.category.CategoryUpdateRequest;
import com.foodygo.inventory.dto.response.category.CategoryCreateResponse;
import com.foodygo.inventory.dto.response.category.CategoryResponse;
import com.foodygo.inventory.dto.response.category.CategoryUpdateResponse;
import com.foodygo.inventory.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toCreateEntity(CategoryCreateRequest categoryCreateRequest);
    Category toUpdateEntity(CategoryUpdateRequest categoryUpdateRequest);
    CategoryCreateResponse toCreateResponse(Category category);
    CategoryUpdateResponse toUpdateResponse(Category category);
    CategoryResponse toResponse(Category category);
}
