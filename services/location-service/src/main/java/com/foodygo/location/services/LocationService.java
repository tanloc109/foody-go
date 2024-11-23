package com.foodygo.location.services;

import com.foodygo.location.dto.response.ProvinceResponseDTO;

import java.util.List;

public interface LocationService {

    void initLocation();

    List<ProvinceResponseDTO> getAllLocations();
}
