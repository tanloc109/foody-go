package com.foodygo.shipping.repository;

import com.foodygo.shipping.entity.ShipperLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperLogRepository extends JpaRepository<ShipperLog, Integer> {

    @Query("SELECT s FROM ShipperLog s WHERE s.deleted = false")
    List<ShipperLog> findAllActive();
}
