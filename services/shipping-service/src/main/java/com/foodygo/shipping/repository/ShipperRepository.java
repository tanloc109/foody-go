package com.foodygo.shipping.repository;

import com.foodygo.shipping.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

    @Query("SELECT s FROM Shipper s WHERE s.deleted = false")
    List<Shipper> findAllActive();

    @Query("SELECT s FROM Shipper s WHERE s.deleted = false and s.id = ?1")
    Optional<Shipper> findByIdNotDeleted(Integer shipperId);
}
