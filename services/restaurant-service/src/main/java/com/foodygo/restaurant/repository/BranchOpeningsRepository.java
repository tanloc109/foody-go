package com.foodygo.restaurant.repository;

import com.foodygo.restaurant.entity.BranchOpenings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOpeningsRepository extends JpaRepository<BranchOpenings, Integer> {
    List<BranchOpenings> findAllByIsDeletedFalse();
    BranchOpenings findByIsDeletedFalse(Integer id);
}
