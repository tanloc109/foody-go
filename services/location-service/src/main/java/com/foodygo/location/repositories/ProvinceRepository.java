package com.foodygo.location.repositories;

import com.foodygo.location.entities.Province;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends MongoRepository<Province, Integer> {
}
