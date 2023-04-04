package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Models.Game;
import com.company.gamestore.Models.TShirt;
import com.company.gamestore.Repositories.GameRepository;
import com.company.gamestore.Repositories.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TShirtService {

    @Autowired
    private TShirtRepository tshirtRepo;

    @Autowired
    public TShirtService(TShirtRepository tshirtRepo) {
        this.tshirtRepo = tshirtRepo;
    }


    public TShirt saveTShirt(TShirt tshirt) {
        return tshirtRepo.save(tshirt);
    }

    public TShirt findTShirt(int id) {
        Optional<TShirt> tshirt = tshirtRepo.findById(id);
        return tshirt.isPresent() ? tshirt.get() : null;
    }

    public List<TShirt> findTShirtByColor(String color) {
        return tshirtRepo.findByColor(color);
    }

    public List<TShirt> findTShirtBySize(String size) {
        return tshirtRepo.findBySize(size);
    }

    public List<TShirt> findAllTShirts() {

        return tshirtRepo.findAll();
    }

    public void updateTShirt(TShirt tshirt) {
        tshirtRepo.save(tshirt);
    }

    public void removeTShirt(int id) {

        tshirtRepo.deleteById(id);
    }
}
