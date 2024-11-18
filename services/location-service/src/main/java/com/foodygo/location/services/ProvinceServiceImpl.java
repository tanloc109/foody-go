package com.foodygo.location.services;

import com.foodygo.location.entities.Province;
import com.foodygo.location.exception.IdNotFoundException;
import com.foodygo.location.repositories.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;


    @Override
    public Province findById(Integer provinceId) {
        return provinceRepository.findById(provinceId)
                .orElseThrow(() -> new IdNotFoundException("Province ID Not Found!"));
    }

    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }
}
