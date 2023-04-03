package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {
    Optional<Fee> findByProductType(String productType);

}

