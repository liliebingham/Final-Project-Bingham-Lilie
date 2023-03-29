package com.company.gamestore.Repositories;

import com.company.gamestore.Models.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtRepositoryTest {
    @Autowired
    TShirtRepository tShirtRepo;

    @Before
    public void setUp() throws Exception {
        tShirtRepo.deleteAll();
    }

    // testing a POST route that creates a new t-shirt
    @Test
    public void shouldCreateNewTShirt() {
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);
        inputTShirt = tShirtRepo.save(inputTShirt);

        Optional<TShirt> tShirt1 = tShirtRepo.findById(inputTShirt.getId());
        assertEquals(tShirt1.get(), inputTShirt);
    }

    // testing a GET route that returns a specific t-shirt by id
    @Test
    public void shouldGetTShirtById() {
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);
        inputTShirt = tShirtRepo.save(inputTShirt);

        Optional<TShirt> tShirt1 = tShirtRepo.findById(inputTShirt.getId());
        assertEquals(tShirt1.get(), inputTShirt);
    }

    // testing a GET route that returns all t-shirts
    @Test
    public void shouldGetAllTShirts() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("S");
        tShirt1.setColor("Red");
        tShirt1.setDescription("Hollywood");
        tShirt1.setPrice(new BigDecimal("11.99"));
        tShirt1.setQuantity(20);
        tShirtRepo.save(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("L");
        tShirt2.setColor("Blue");
        tShirt2.setDescription("Hollywood");
        tShirt2.setPrice(new BigDecimal("11.99"));
        tShirt2.setQuantity(20);
        tShirtRepo.save(tShirt2);

        List<TShirt> tShirtList = tShirtRepo.findAll();
        //Assert...
        assertEquals(2, tShirtList.size());
    }

    // testing a PUT route that updates an existing t-shirt
    @Test
    public void shouldUpdateTShirt() {
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);
        inputTShirt = tShirtRepo.save(inputTShirt);
        inputTShirt.setDescription("UPDATED");
        inputTShirt = tShirtRepo.save(inputTShirt);

        Optional<TShirt> tShirt1 = tShirtRepo.findById(inputTShirt.getId());
        assertEquals(tShirt1.get(), inputTShirt);
    }

    // testing a DELETE route that deletes an existing t-shirt
    @Test
    public void shouldDeleteTShirt() {
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("Hollywood");
        inputTShirt.setPrice(new BigDecimal("11.99"));
        inputTShirt.setQuantity(20);

        inputTShirt = tShirtRepo.save(inputTShirt);

        Optional<TShirt> tShirt1 = tShirtRepo.findById(inputTShirt.getId());
        assertFalse(tShirt1.isPresent());
    }


    // testing a GET route that returns all t-shirts by color
    @Test
    public void shouldFindByColor() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("S");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("Hollywood");
        tShirt1.setPrice(new BigDecimal("11.99"));
        tShirt1.setQuantity(20);
        tShirtRepo.save(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("S");
        tShirt2.setColor("Red");
        tShirt2.setDescription("Hollywood");
        tShirt2.setPrice(new BigDecimal("11.99"));
        tShirt2.setQuantity(20);
        tShirtRepo.save(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("S");
        tShirt3.setColor("Yellow");
        tShirt3.setDescription("Hollywood");
        tShirt3.setPrice(new BigDecimal("11.99"));
        tShirt3.setQuantity(20);
        tShirtRepo.save(tShirt3);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("S");
        tShirt4.setColor("Red");
        tShirt4.setDescription("Hollywood");
        tShirt4.setPrice(new BigDecimal("11.99"));
        tShirt4.setQuantity(20);
        tShirtRepo.save(tShirt4);

        List<TShirt> tShirtList = tShirtRepo.findByColor("Red");
        assertEquals(tShirtList.size(), 2);
    }

    // testing a GET route that returns all t-shirts by size
    @Test
    public void shouldFindBySize() {
        TShirt tShirt1 = new TShirt();
        tShirt1.setSize("S");
        tShirt1.setColor("Blue");
        tShirt1.setDescription("Hollywood");
        tShirt1.setPrice(new BigDecimal("11.99"));
        tShirt1.setQuantity(20);
        tShirtRepo.save(tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("S");
        tShirt2.setColor("Red");
        tShirt2.setDescription("Hollywood");
        tShirt2.setPrice(new BigDecimal("11.99"));
        tShirt2.setQuantity(20);
        tShirtRepo.save(tShirt2);

        TShirt tShirt3 = new TShirt();
        tShirt3.setSize("S");
        tShirt3.setColor("Yellow");
        tShirt3.setDescription("Hollywood");
        tShirt3.setPrice(new BigDecimal("11.99"));
        tShirt3.setQuantity(20);
        tShirtRepo.save(tShirt3);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("S");
        tShirt4.setColor("Red");
        tShirt4.setDescription("Hollywood");
        tShirt4.setPrice(new BigDecimal("11.99"));
        tShirt4.setQuantity(20);
        tShirtRepo.save(tShirt4);

        List<TShirt> tShirtList = tShirtRepo.findBySize("S");
        assertEquals(tShirtList.size(), 4);
    }
}