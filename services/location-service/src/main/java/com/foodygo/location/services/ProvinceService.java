package com.foodygo.location.services;

import com.foodygo.location.entities.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    Province findById(Integer provinceId);
    Province save(Province province);
}
