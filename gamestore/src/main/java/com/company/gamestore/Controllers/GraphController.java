package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Models.Game;
import com.company.gamestore.Repositories.ConsoleRepository;
import com.company.gamestore.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {
    @Autowired
    GameRepository gameRepo;

    @Autowired
    ConsoleRepository consoleRepo;

    @QueryMapping
    public List<Game> findAllGames() {
        return gameRepo.findAll();
    }

    @QueryMapping
    public List<Console> findAllConsoles() {
        return consoleRepo.findAll();
    }

    @QueryMapping
    public Game findGameById(@Argument int game_id) {
        Optional<Game> returnVal = gameRepo.findById(game_id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public Console findConsoleById(@Argument int console_id) {
        Optional<Console> returnVal = consoleRepo.findById(console_id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public List<Console> findConsoleByManufacturer(@Argument String manufacturer) {
        List<Console> returnVal = consoleRepo.findByManufacturer(manufacturer);
        return returnVal;
    }

    @QueryMapping
    public Game findGameByTitle(@Argument String title) {
        Optional<Game> returnVal = gameRepo.findByTitle(title);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @QueryMapping
    public List<Game> findGameByESRB(@Argument String esrb) {
        List<Game> returnVal = gameRepo.findByEsrbRating(esrb);
        return returnVal;
    }

    @QueryMapping
    public List<Game> findGameByStudio(@Argument String studio) {
        List<Game> returnVal = gameRepo.findByStudio(studio);
        return returnVal;
    }

}
