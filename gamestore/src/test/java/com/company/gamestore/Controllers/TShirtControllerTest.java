package com.company.gamestore.Controllers;

import com.company.gamestore.Models.TShirt;
import com.company.gamestore.Repositories.TShirtRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TShirtRepository TShirtRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A list of tShirts for testing purposes
    private List<TShirt> tShirtList;

    // testing POST route /tShirt that creates a new tShirt
    @Test
    public void shouldReturnNewTShirtOnPostRequest() throws Exception {
        // ARRANGE
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(inputTShirt);

        // ACT
        mockMvc.perform(
                        post("/tShirt")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());              // ASSERT (status code is 201)
    }

    // testing PUT /tShirt route that updates an existing tShirt
    @Test
    public void shouldUpdateByIdAndReturn204StatusCode() throws Exception {
        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);
        String inputJson = mapper.writeValueAsString(inputTShirt);

        mockMvc.perform(
                        put("/tShirt")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // testing DELETE /tshirt/{id} route that deletes an existing TShirt
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/tShirt/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // testing GET /tshirt/{id} route that returns a specific TShirt by id
    @Test
    public void shouldReturnTShirtById() throws Exception {
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);
        inputTShirt.setId(2);

        String inputJson = mapper.writeValueAsString(inputTShirt);

        mockMvc.perform(get("/tShirt/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // testing GET /TShirt route that returns all TShirts
    @Test
    public void shouldReturnAllPublishers() throws Exception {
        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(tShirtList);

        // ACT
        mockMvc.perform(get("/tShirt"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // testing GET /tShirt/{color} route that returns all tShirts by color
    @Test
    public void shouldReturnAllTShirtsByColor() throws Exception {
        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(tShirtList);

        // ACT
        mockMvc.perform(get("/tShirt/color/red"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }
}