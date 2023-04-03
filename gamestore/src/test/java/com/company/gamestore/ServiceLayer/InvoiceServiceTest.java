package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Models.Invoice;
import com.company.gamestore.Repositories.*;
import com.company.gamestore.ViewModel.InvoiceViewModel;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InvoiceServiceTest {
    InvoiceRepository invoiceRepo;
    GameRepository gameRepo;
    ConsoleRepository consoleRepo;
    TShirtRepository tshirtRepo;
    FeeRepository feeRepo;
    TaxRepository taxRepo;
    InvoiceService invoiceService = new InvoiceService(taxRepo,  feeRepo,  gameRepo, tshirtRepo,  consoleRepo, invoiceRepo);

    @Test
    public void shouldSaveInvoice() {
        InvoiceViewModel testViewModel = new InvoiceViewModel();
        Invoice newInvoice = new Invoice();

        testViewModel.setName("John Doe");
        testViewModel.setStreet("123 Ocean Avenue");
        testViewModel.setCity("Los Angeles");
        testViewModel.setState("CA");
        testViewModel.setZipcode("08520");
        testViewModel.setItem_type("Shirt");
        testViewModel.setItem_id(2);
        testViewModel.setQuantity(1);

        newInvoice = invoiceService.saveInvoice(testViewModel);

        //test to check if the subtotal, fee, tax and total are correct


    }

    @Test
    public void shouldUpdateInventoryQuantity() {

    }
}