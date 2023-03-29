package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Repositories.ConsoleRepository;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private ConsoleRepository consoleRepo;

    @Before
    public void setUp() {
        consoleRepo.deleteAll();
    }


    // Testing POST /consoles
    @Test
    public void shouldAddConsoleAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);

        consoleRepo.save(console);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(post("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing PUT /consoles
    @Test
    public void shouldUpdateConsoleAndReturn204StatusCode() throws Exception {

        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content

        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);

        consoleRepo.save(console);

        console.setQuantity(5);

        String inputJson = mapper.writeValueAsString(console);

        mockMvc.perform(put("/consoles")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }



    // Testing GET /consoles/{id}
    @Test
    public void shouldReturnConsoleByID() throws Exception {


        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);
        console.setConsole_id(1);

        consoleRepo.save(console);

        // ACT
        mockMvc.perform(get("/consoles/1"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    // Testing GET /consoles
    @Test
    public void shouldReturnAllConsoles() throws Exception {

        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);

        consoleRepo.save(console);

        // ACT
        mockMvc.perform(get("/consoles"))                  // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }


    // Testing DELETE /consoles/{id}
    @Test
    public void shouldDeleteAuthorAndReturn204StatusCode() throws Exception {
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);
        console.setConsole_id(1);

        consoleRepo.save(console);


        // This method returns nothing, so we're just checking for correct status code
        // In this case, code 204, which indicates No Content
        mockMvc.perform(delete("/consoles/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    // Testing GET consoles/manufacturer/{manufacturer}
    @Test
    public void shouldReturnConsoleByManufacturer() throws Exception {

        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);

        consoleRepo.save(console);

        mockMvc.perform(get("/consoles/manufacturer/Nintendo"))
                .andDo(print())
                .andExpect(status().isOk());

    }









}