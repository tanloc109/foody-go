package com.foodygo.location.services;

import com.foodygo.location.entities.Ward;
import com.foodygo.location.exception.IdNotFoundException;
import com.foodygo.location.repositories.WardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WardServiceImpl implements WardService {

    private final WardRepository wardRepository;

    @Override
    public Ward findById(Integer wardId) {
        return wardRepository.findById(wardId)
                .orElseThrow(() -> new IdNotFoundException("Ward Not Found"));
    }

    @Override
    public Ward save(Ward ward) {
        return wardRepository.save(ward);
    }
}
