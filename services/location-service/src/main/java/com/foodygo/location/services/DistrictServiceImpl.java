package com.foodygo.location.services;

import com.foodygo.location.entities.District;
import com.foodygo.location.exception.IdNotFoundException;
import com.foodygo.location.repositories.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Override
    public District findById(Integer districtId) {
        return districtRepository.findById(districtId)
                .orElseThrow(() -> new IdNotFoundException("District ID Not Found!"));
    }

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }
}
