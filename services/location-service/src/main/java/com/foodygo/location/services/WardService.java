package com.foodygo.location.services;

import com.foodygo.location.entities.Ward;

public interface WardService {
    Ward findById(Integer wardId);
    Ward save(Ward ward);
}
