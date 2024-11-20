package com.foodygo.location.repositories;

import com.foodygo.location.entities.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends MongoRepository<District, Integer> {
}
