package com.foodygo.restaurant.service;

import com.foodygo.restaurant.dto.request.CreateBrandRequest;
import com.foodygo.restaurant.dto.request.UpdateBrandRequest;
import com.foodygo.restaurant.dto.response.BrandResponse;
import com.foodygo.restaurant.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();
    Brand findById(Integer id);
    Object delete(Integer id);
    List<BrandResponse> findAllBrands();
    BrandResponse findByBrandId(Integer id);
    BrandResponse createBrand(CreateBrandRequest request);
    BrandResponse update(Integer id, UpdateBrandRequest request);
}
