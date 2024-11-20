package com.foodygo.location.services;

import com.foodygo.location.entities.District;

public interface DistrictService {
    District findById(Integer districtId);
    District save(District district);
}
