package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Models.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Integer> {
}
