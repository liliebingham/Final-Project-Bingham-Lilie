package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

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
    public void addGame() {
        //Arrange...
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrb_rating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal(20));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        //Act...
        game = repo.save(game);

        //Assert...
        Optional<Game> foundGame = repo.findById(game.getGame_id());

        assertEquals(foundGame.get(), game);
    }
}
