package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRepositoryTests {
    @Autowired
    GameRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    //Test Create Game
    @Test
    public void shouldAddGame() {
        //Arrange...
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        //Act...
        game = repo.save(game);

        //Assert...
        Optional<Game> foundGame = repo.findById(game.getGame_id());

        assertEquals(foundGame.get(), game);
    }

    //Test Get Game By Id
    @Test
    public void shouldGetGameById() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        //Act...
        game1 = repo.save(game1);
        game2 = repo.save(game2);

        //Assert...
        Optional<Game> foundGame = repo.findById(game1.getGame_id());

        assertEquals(foundGame.get(), game1);
    }

    //Test Get All Games
    @Test
    public void shouldGetAllGames() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        //Act...
        game1 = repo.save(game1);
        game2 = repo.save(game2);

        //Assert...
        List<Game> gamesList = repo.findAll();
        assertEquals(gamesList.size(), 2);
    }

    //Test Update Game
    @Test
    public void shouldUpdateGames() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        //Act...
        game1 = repo.save(game1);
        game1.setEsrbRating("M");
        repo.save(game1);

        //Assert...
        Optional<Game> foundGame = repo.findById(game1.getGame_id());

        assertEquals(foundGame.get(), game1);
    }

    //Test Delete Game
    @Test
    public void shouldDeleteGames() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        //Act...
        game1 = repo.save(game1);

        //Act...
        repo.deleteById(game1.getGame_id());

        //Assert...
        Optional<Game> deletedGame = repo.findById(game1.getGame_id());
        assertFalse(deletedGame.isPresent());
    }

    //Test Find Game By Studio
    @Test
    public void shouldFindGameByStudio() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        Game game3 = new Game();
        game3.setTitle("Ark Survival Evolved");
        game3.setEsrbRating("T");
        game3.setDescription("A game where you fight dinosaurs!");
        game3.setPrice(new BigDecimal("59.99"));
        game3.setStudio("Microsoft");
        game3.setQuantity(150);

        //Act...
        game1 = repo.save(game1);
        game2 = repo.save(game2);
        game3 = repo.save(game3);

        //Act...
        List<Game> concernedApeList = repo.findByStudio("ConcernedApe");
        List<Game> microsoftList = repo.findByStudio("Microsoft");

        //Assert...
        assertEquals(1, concernedApeList.size());
        assertEquals(2, microsoftList.size());
    }

    //Test Find Game By Title
    @Test
    public void shouldFindGameByTitle() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        Game game3 = new Game();
        game3.setTitle("Ark Survival Evolved");
        game3.setEsrbRating("T");
        game3.setDescription("A game where you fight dinosaurs!");
        game3.setPrice(new BigDecimal("59.99"));
        game3.setStudio("Microsoft");
        game3.setQuantity(150);

        //Act...
        game1 = repo.save(game1);
        game2 = repo.save(game2);
        game3 = repo.save(game3);

        //Act...
        Optional<Game> foundGame = repo.findByTitle("Stardew Valley");

        //Assert...
        assertEquals(foundGame.get(), game2);
    }

    //Test Find All Games by Esrb Rating
    @Test
    public void shouldFindGameByEsrb() {
        //Arrange...
        Game game1 = new Game();
        game1.setTitle("Minecraft");
        game1.setEsrbRating("E");
        game1.setDescription("A game where you mine and craft!");
        game1.setPrice(new BigDecimal("20.00"));
        game1.setStudio("Microsoft");
        game1.setQuantity(100);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        Game game3 = new Game();
        game3.setTitle("Ark Survival Evolved");
        game3.setEsrbRating("T");
        game3.setDescription("A game where you fight dinosaurs!");
        game3.setPrice(new BigDecimal("59.99"));
        game3.setStudio("Microsoft");
        game3.setQuantity(150);

        //Act...
        game1 = repo.save(game1);
        game2 = repo.save(game2);
        game3 = repo.save(game3);

        //Act...
        List<Game> tList = repo.findByEsrbRating("T");
        List<Game> eList = repo.findByEsrbRating("E");

        //Assert...
        assertEquals(1, tList.size());
        assertEquals(2, eList.size());
    }

}
