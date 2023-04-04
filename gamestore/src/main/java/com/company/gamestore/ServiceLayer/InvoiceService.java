package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Models.*;
import com.company.gamestore.Repositories.*;
import com.company.gamestore.ViewModel.InvoiceViewModel;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class InvoiceService {
    @Autowired
    private TaxRepository taxRepo;
    private FeeRepository feeRepo;
    private GameRepository gameRepo;
    private TShirtRepository tshirtRepo;
    private ConsoleRepository consoleRepo;
    private InvoiceRepository invoiceRepo;


    @Autowired
    public InvoiceService(TaxRepository taxRepo, FeeRepository feeRepo, GameRepository gameRepo, TShirtRepository tshirtRepo, ConsoleRepository consoleRepo, InvoiceRepository invoiceRepo) {
        this.taxRepo = taxRepo;
        this.feeRepo = feeRepo;
        this.gameRepo = gameRepo;
        this.tshirtRepo = tshirtRepo;
        this.consoleRepo = consoleRepo;
        this.invoiceRepo = invoiceRepo;
    }

    public Invoice saveInvoice(InvoiceViewModel invoiceViewModel){
        BigDecimal unitPrice = new BigDecimal(0);
        int itemId = invoiceViewModel.getItem_id();
        int quantity = invoiceViewModel.getQuantity();
        String itemType = invoiceViewModel.getItem_type();
        Invoice newInvoice;

        // calculate unit price
        switch(itemType){
            case "Game": //make sure we have item id, if don't have item then say no item type with this id (not found exception)
                unitPrice = gameRepo.getReferenceById(itemId).getPrice();
                break;
            case "TShirt":
                unitPrice = tshirtRepo.getReferenceById(itemId).getPrice();
                break;
            case "Console":
                unitPrice = consoleRepo.getReferenceById(itemId).getPrice();
                break;
            default:
                //error unprocessable entity
        }

        // calculate subtotal, tax, processing fee, total
        //test quantity to make sure we have inventory (illegal argument exception)
        BigDecimal subtotal = unitPrice.multiply(new BigDecimal(quantity));
        //make sure state is valid, in state list, if not throw an error (optional)
        BigDecimal tax = taxRepo.findByState(invoiceViewModel.getState()).get().getRate(); //maybe don't need extra get()
        BigDecimal totalTax = subtotal.multiply(tax);
        BigDecimal processingFee = feeRepo.findByProductType(itemType).get().getFee();
        if(quantity > 10) {
            processingFee.add(new BigDecimal(15.49));
        }
        BigDecimal total = subtotal.add(totalTax).add(processingFee); //double check formatting (set scale) to 2 for 2 decimals, round half up

        //max total can be 999.99 at most, if total is greater than throw an error saying it should be under 1k
        updateInventoryQuantity(itemType, itemId, quantity);

        // create invoice
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItem_type(itemType);
        invoice.setItem_id(itemId);
        invoice.setUnit_price(unitPrice);
        invoice.setQuantity(quantity);
        invoice.setSubtotal(subtotal);
        invoice.setTax(totalTax);
        invoice.setProcessing_fee(processingFee);
        invoice.setTotal(total);

        invoice = invoiceRepo.save(invoice);
        return invoice;
    }

    public void updateInventoryQuantity(String itemType, int itemId, int quantity){
        int newQuantity;
        switch(itemType){
            case "Game":
                Game updatedGame = gameRepo.getReferenceById(itemId);
                newQuantity = updatedGame.getQuantity() - quantity < 0 ? 0 : updatedGame.getQuantity() - quantity;
                updatedGame.setQuantity(newQuantity);
                gameRepo.save(updatedGame);
                break;
            case "TShirt":
                TShirt updatedTShirt = tshirtRepo.getReferenceById(itemId);
                newQuantity = updatedTShirt.getQuantity() - quantity < 0 ? 0 : updatedTShirt.getQuantity() - quantity;
                updatedTShirt.setQuantity(newQuantity);
                tshirtRepo.save(updatedTShirt);
                break;
            case "Console":
                Console updatedConsole = consoleRepo.getReferenceById(itemId);
                newQuantity = updatedConsole.getQuantity() - quantity < 0 ? 0 : updatedConsole.getQuantity() - quantity;
                updatedConsole.setQuantity(newQuantity);
                consoleRepo.save(updatedConsole);
                break;
            default:
                //error
        }
    }

}
