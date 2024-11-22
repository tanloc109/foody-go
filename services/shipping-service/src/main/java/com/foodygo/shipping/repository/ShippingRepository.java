package com.foodygo.shipping.repository;

import com.foodygo.shipping.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

    @Query("SELECT s FROM Shipping s WHERE s.deleted = false")
    List<Shipping> findAllActive();

    List<Shipping> findByBranchId(Integer branchId);

    Optional<Shipping> findByOrderId(Integer orderId);
}
