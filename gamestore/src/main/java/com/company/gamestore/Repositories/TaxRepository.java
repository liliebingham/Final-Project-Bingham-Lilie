package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {
    Optional<Tax> findByState(String state);
}



