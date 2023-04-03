package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Game;
import com.company.gamestore.Repositories.GameRepository;
import com.company.gamestore.ServiceLayer.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    GameService serviceLayer;

    // POST route that creates a game
    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        return serviceLayer.saveGame(game);
    }

    // GET route that get a game by id
    @GetMapping("/games/{id}")
    public Game getGameById(@PathVariable Integer id) {

        return serviceLayer.findGame(id);
    }

    // GET route that returns all games
    @GetMapping("/games")
    public List<Game> getGames() {
        return serviceLayer.findAllGames();
    }

    // PUT route that updates a game
    @PutMapping("/games")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody Game game) {
        serviceLayer.updateGame(game);
    }

    // DELETE route that deletes a game
    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id) {
        serviceLayer.removeGame(id);
    }

    // GET route that returns all games by Studio
    @GetMapping("/games/studios/{studio}")
    public List<Game> getGameByStudio(@PathVariable String studio) {

        return serviceLayer.findGameByStudio(studio);
    }

    // GET route that returns all games by Esrb Rating
    @GetMapping("/games/esrb/{esrb}")
    public List<Game> getGameByEsrbRating(@PathVariable String esrb) {

        return serviceLayer.findGameByEsrb(esrb);
    }

    // GET route that returns all games by Title
    @GetMapping("/games/titles/{title}")
    public Optional<Game> getGameByTitle(@PathVariable String title) {

        return serviceLayer.findGameByTitle(title);
    }

}
