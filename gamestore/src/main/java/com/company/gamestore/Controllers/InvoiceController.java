package com.company.gamestore.Controllers;


import com.company.gamestore.Models.Game;
import com.company.gamestore.Models.Invoice;
import com.company.gamestore.Repositories.GameRepository;
import com.company.gamestore.Repositories.InvoiceRepository;
import com.company.gamestore.ServiceLayer.InvoiceService;
import com.company.gamestore.ViewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    // POST route that creates an invoice
    @PostMapping("/invoices")
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoice(@RequestBody InvoiceViewModel invoice) {
        return invoiceService.saveInvoice(invoice);
    }

}
