package com.foodygo.restaurant.repository;

import com.foodygo.restaurant.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    List<Branch> findAllByIsDeletedFalse();
    Branch findByIsDeletedFalse(Integer id);
}
