package com.foodygo.location.services;

import com.foodygo.location.entities.District;
import com.foodygo.location.entities.Province;
import com.foodygo.location.entities.Ward;
import com.foodygo.location.exception.IdNotFoundException;
import com.foodygo.location.repositories.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAllByIsDeletedIsFalse();
    }

    @Override
    public Province findById(Integer provinceId) {
        return provinceRepository.findById(provinceId)
                .orElseThrow(() -> new IdNotFoundException("Province Not Found!"));
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

}
