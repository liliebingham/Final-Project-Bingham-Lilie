package com.company.gamestore.Controllers;

import com.company.gamestore.Models.TShirt;
import com.company.gamestore.Repositories.TShirtRepository;
import com.company.gamestore.ServiceLayer.ConsoleService;
import com.company.gamestore.ServiceLayer.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TShirtController {

    @Autowired
    TShirtService serviceLayer;

    // A POST route that creates a new t-shirt
    @PostMapping("/tShirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt addTShirt(@RequestBody TShirt tShirt) {
        return serviceLayer.saveTShirt(tShirt);
    }

    // A GET route that returns a specific t-shirt by id
    @GetMapping("/tShirt/{id}")
    public TShirt getTShirtById(@PathVariable int id) {
        return serviceLayer.findTShirt(id);
    }

    // A GET route that returns all t-shirts
    @GetMapping("/tShirt")
    public List<TShirt> getAllTShirts() {
        return serviceLayer.findAllTShirts();
    }

    // A PUT route that updates an existing t-shirt
    @PutMapping("/tShirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void TShirt(@RequestBody TShirt tShirt) {
        serviceLayer.updateTShirt(tShirt);
    }

    // A DELETE route that deletes an existing t-shirt
    @DeleteMapping("/tShirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) { serviceLayer.removeTShirt(id); }

    // A GET route that returns all t-shirts by color
    @GetMapping("/tShirt/color/{color}")
    public List<TShirt> getAllTShirtsByColor(@PathVariable String color) {
        return serviceLayer.findTShirtByColor(color);
    }

    // A GET route that returns all t-shirts by size
    @GetMapping("/tShirt/size/{size}")
    public List<TShirt> getAllTShirtsBySize(@PathVariable String size) {
        return serviceLayer.findTShirtBySize(size);
    }


}
