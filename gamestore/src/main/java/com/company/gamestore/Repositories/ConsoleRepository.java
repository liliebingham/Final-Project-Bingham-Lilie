package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConsoleRepository  extends JpaRepository<Console, Integer> {

    List<Console> findByManufacturer(String manufacturer);

}
