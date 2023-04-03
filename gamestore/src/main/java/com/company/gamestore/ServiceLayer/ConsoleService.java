package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Models.Console;
import com.company.gamestore.Repositories.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepo;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepo) {
        this.consoleRepo = consoleRepo;
    }


    public Console saveConsole(Console console) {

        return consoleRepo.save(console);
    }

    public Console findConsole(int id) {

        Optional<Console> console = consoleRepo.findById(id);
        return console.isPresent() ? console.get() : null;
    }

    public List<Console> findConsoleByManufacturer(String manufacturer) {
        return consoleRepo.findByManufacturer(manufacturer);
    }

    public List<Console> findAllConsoles() {

        return consoleRepo.findAll();
    }

    public void updateConsole(Console console) {

        consoleRepo.save(console);
    }

    public void removeConsole(int id) {

        consoleRepo.deleteById(id);
    }
}
