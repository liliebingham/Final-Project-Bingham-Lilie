package com.company.gamestore.Controllers;

import com.company.gamestore.Models.TShirt;
import com.company.gamestore.Repositories.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TShirtController {
    @Autowired
    TShirtRepository repo;

    // A POST route that creates a new t-shirt
    @PostMapping("/tShirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt addTShirt(@RequestBody TShirt tShirt) {
        return repo.save(tShirt);
    }

    // A GET route that returns a specific t-shirt by id
    @GetMapping("/tShirt/{id}")
    public TShirt getTShirtById(@PathVariable int id) {
        Optional<TShirt> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // A GET route that returns all t-shirts
    @GetMapping("/tShirt")
    public List<TShirt> getAllTShirts() {
        return repo.findAll();
    }

    // A PUT route that updates an existing t-shirt
    @PutMapping("/tShirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void TShirt(@RequestBody TShirt tShirt) {
        repo.save(tShirt);
    }

    // A DELETE route that deletes an existing t-shirt
    @DeleteMapping("/tShirt/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) { repo.deleteById(id); }

    // A GET route that returns all t-shirts by color
    @GetMapping("/tShirt/color/{color}")
    public List<TShirt> getAllTShirtsByColor(@PathVariable String color) {
        return repo.findByColor(color);
    }

    // A GET route that returns all t-shirts by size
    @GetMapping("/tShirt/size/{size}")
    public List<TShirt> getAllTShirtsBySize(@PathVariable String size) {
        return repo.findBySize(size);
    }


}
