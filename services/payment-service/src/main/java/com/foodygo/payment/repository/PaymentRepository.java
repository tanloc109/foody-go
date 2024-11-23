package com.foodygo.payment.repository;

import com.foodygo.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByIdAndIsDeletedFalse(Integer id);
    List<Payment> findByCustomerIdAndIsDeletedFalse(Integer id);
}
