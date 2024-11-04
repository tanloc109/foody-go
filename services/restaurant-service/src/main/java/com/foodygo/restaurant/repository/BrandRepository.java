package com.foodygo.restaurant.repository;

import com.foodygo.restaurant.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByIsDeletedFalse();
    Brand findByIsDeletedFalse(Integer id);
}
