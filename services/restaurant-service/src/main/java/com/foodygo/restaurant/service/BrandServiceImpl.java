package com.foodygo.restaurant.service;

import com.foodygo.restaurant.dto.request.CreateBrandRequest;
import com.foodygo.restaurant.dto.request.UpdateBrandRequest;
import com.foodygo.restaurant.dto.response.BrandResponse;
import com.foodygo.restaurant.entity.Brand;
import com.foodygo.restaurant.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return List.of();
    }

    @Override
    public Brand findById(Integer id) {
        return null;
    }

    @Override
    public Object delete(Integer id) {
        return null;
    }

    @Override
    public List<BrandResponse> findAllBrands() {
        return List.of();
    }

    @Override
    public BrandResponse findByBrandId(Integer id) {
        return null;
    }

    @Override
    public BrandResponse createBrand(CreateBrandRequest request) {
        return null;
    }

    @Override
    public BrandResponse update(Integer id, UpdateBrandRequest request) {
        return null;
    }
}
