package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Models.Game;
import com.company.gamestore.Repositories.ConsoleRepository;
import com.company.gamestore.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    @Autowired
    public GameService(GameRepository gameRepo) {
        this.gameRepo = gameRepo;
    }


    public Game saveGame(Game game) {

        return gameRepo.save(game);
    }

    public Game findGame(int id) {

        Optional<Game> game = gameRepo.findById(id);
        return game.isPresent() ? game.get() : null;
    }

    public List<Game> findGameByStudio(String studio) {
        return gameRepo.findByStudio(studio);
    }

    public List<Game> findGameByEsrb(String esrb) {
        return gameRepo.findByEsrbRating(esrb);
    }

    public Optional<Game> findGameByTitle(String title) {
        return gameRepo.findByTitle(title);
    }

    public List<Game> findAllGames() {

        return gameRepo.findAll();
    }

    public void updateGame(Game game) {

        gameRepo.save(game);
    }

    public void removeGame(int id) {

        gameRepo.deleteById(id);
    }
}
