package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findByStudio(String studio);
    Optional<Game> findByTitle(String title);
    List<Game> findByEsrbRating(String esrb_rating);

}
