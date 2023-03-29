package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Game;
import com.company.gamestore.Repositories.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTests {

    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;


    // ObjectMapper used to convert Java objects to JSON and vice versa
    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    // Customer Repository for testing purposes
    @MockBean
    private GameRepository repo;

    @Before
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }

    // Testing POST /games
    @Test
    public void shouldReturnNewGameOnPostRequest() throws Exception {

        //Arrange...
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(game);

        // ACT
        mockMvc.perform(
                        post("/games")                             // Perform the POST request
                                .content(inputJson)                          // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)     // Tell the server it's in JSON format
                )
                .andDo(print())                                              // Print results to console
                .andExpect(status().isCreated());                            // ASSERT (status code is 201)
    }

    // Testing (Update) PUT /games/{id}
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(game);

        mockMvc.perform(
                        put("/games")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing DELETE /games/{id}
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        String id = Integer.toString(game.getGame_id());

        mockMvc.perform(delete("/games/" + id))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET games/{id}
    @Test
    public void shouldReturnGameById() throws Exception {

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        String id = Integer.toString(game.getGame_id());

        mockMvc.perform(get("/games/" + id))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET games/studio/{studio}
    @Test
    public void shouldReturnGamesByStudio() throws Exception {

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        List<Game> myList = new ArrayList<Game>();
        myList.add(game);

        mockMvc.perform(get("/games/studios/Microsoft"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET games/esrb/{esrb}
    @Test
    public void shouldReturnGamesByEsrbRating() throws Exception {

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        List<Game> myList = new ArrayList<Game>();
        myList.add(game);

        mockMvc.perform(get("/games/esrb/E"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing GET games/titles/{title}
    @Test
    public void shouldReturnGamesByTitle() throws Exception {

        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);

        repo.save(game);

        mockMvc.perform(get("/games/titles/Minecraft"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
