package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ConsoleRepository  extends JpaRepository<Console, Integer> {

    List<Console> findByManufacturer(String manufacturer);

}
