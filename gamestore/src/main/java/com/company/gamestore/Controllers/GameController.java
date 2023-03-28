package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Game;
import com.company.gamestore.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    GameRepository repo;

    // POST route that creates a game
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        return repo.save(game);
    }

    // GET route that creates a game
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable Integer id) {

        Optional<Game> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // GET route that returns all games
    @GetMapping("/games")
    public List<Game> getGames() {
        return repo.findAll();
    }

    // PUT route that updates a game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {
        repo.save(game);
    }

    // DELETE route that deletes a game
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id) {
        repo.deleteById(id);
    }

    // GET route that returns all games by Studio
    @GetMapping("/games/{studio}")
    public List<Game> getGameByStudio(@PathVariable String studio) {

        return repo.findByStudio(studio);
    }


    // GET route that returns all games by Title
    @GetMapping("/games/{title}")
    public List<Game> getGameByTitle(@PathVariable String title) {

        return repo.findByTitle(title);
    }

}
