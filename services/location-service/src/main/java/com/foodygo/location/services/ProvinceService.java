package com.foodygo.location.services;

import com.foodygo.location.entities.Province;

import java.util.List;

public interface ProvinceService {

    Province findById(Integer provinceId);
    Province save(Province province);
}
