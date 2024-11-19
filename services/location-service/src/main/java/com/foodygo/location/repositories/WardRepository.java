package com.foodygo.location.repositories;

import com.foodygo.location.entities.Ward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends MongoRepository<Ward, Integer> {
}
