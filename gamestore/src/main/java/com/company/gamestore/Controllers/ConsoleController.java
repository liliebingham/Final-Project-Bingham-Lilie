package com.company.gamestore.Controllers;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ConsoleController {

    @Autowired
    ConsoleRepository repo;


    // POST route that creates a console
    @PostMapping("/consoles")
    @ResponseStatus(HttpStatus.CREATED)
    public Console addConsole(@RequestBody Console console) {
        return repo.save(console);
    }

    // GET route that reads console by ID
    @GetMapping("/consoles/{id}")
    public Console getConsoleById(@PathVariable Integer id) {
        Optional<Console> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // GET route that gets all consoles
    @GetMapping("/consoles")
    public List<Console> getConsoles() {
        return repo.findAll();
    }

    // PUT route that updates a console
    @PutMapping("/consoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        repo.save(console);
    }

    // DELETE route that deletes a console
    @DeleteMapping("/consoles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        repo.deleteById(id);
    }

    //A GET route that returns all consoles from a certain manufacturer
    @GetMapping("/consoles/manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable String manufacturer) {

        return repo.findByManufacturer(manufacturer);
    }
}
