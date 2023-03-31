package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceService {

    private TaxRepository taxRepo;
    private FeeRepository feeRepo;
    private GameRepository gameRepo;
    private TShirtRepository tshirtRepo;
    private ConsoleRepository consoleRepo;


    @Autowired
    public InvoiceService(TaxRepository taxRepo, FeeRepository feeRepo, GameRepository gameRepo, TShirtRepository tshirtRepo, ConsoleRepository consoleRepo) {
        this.taxRepo = taxRepo;
        this.feeRepo = feeRepo;
        this.gameRepo = gameRepo;
        this.tshirtRepo = tshirtRepo;
        this.consoleRepo = consoleRepo;
    }
}
