package com.company.gamestore.Repositories;

import com.company.gamestore.Controllers.ConsoleController;
import com.company.gamestore.Models.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }


    @Test
    public void addConsole() {
        //Arrange...
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);

        //Act...
        console = repo.save(console);

        //Assert...
        Optional<Console> console1 = repo.findById(console.getConsole_id());

        assertEquals(console1.get(), console);
    }

}