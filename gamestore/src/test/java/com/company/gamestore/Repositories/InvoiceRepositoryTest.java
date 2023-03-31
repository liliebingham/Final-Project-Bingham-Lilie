package com.company.gamestore.Repositories;

import com.company.gamestore.Models.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {
    @Autowired
    InvoiceRepository invoiceRepo;

    @Before
    public void setUp() throws Exception {
        invoiceRepo.deleteAll();
    }

    // test creating new invoice
    @Test
    public void shouldCreateNewInvoice() {
        Invoice inputInvoice1 = new Invoice();
        inputInvoice1.setName("John Doe");
        inputInvoice1.setStreet("123 Ocean Avenue");
        inputInvoice1.setCity("Los Angeles");
        inputInvoice1.setState("CA");
        inputInvoice1.setZipcode("08520");
        inputInvoice1.setItem_type("Shirt");
        inputInvoice1.setItem_id(2);
        inputInvoice1.setUnit_price(new BigDecimal(19.99));
        inputInvoice1.setQuantity(1);
        inputInvoice1.setSubtotal(new BigDecimal(19.99));
        inputInvoice1.setTax(new BigDecimal(0.06));
        inputInvoice1.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice1.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice1);

        Optional<Invoice> foundInvoice = invoiceRepo.findById(inputInvoice1.getInvoice_id());
        assertEquals(foundInvoice.get(), inputInvoice1);
    }

    // test getting a specific invoice by ID
    @Test
    public void shouldGetInvoiceById() {
        Invoice inputInvoice1 = new Invoice();
        inputInvoice1.setName("John Doe");
        inputInvoice1.setStreet("123 Ocean Avenue");
        inputInvoice1.setCity("Los Angeles");
        inputInvoice1.setState("CA");
        inputInvoice1.setZipcode("08520");
        inputInvoice1.setItem_type("Shirt");
        inputInvoice1.setItem_id(2);
        inputInvoice1.setUnit_price(new BigDecimal(19.99));
        inputInvoice1.setQuantity(1);
        inputInvoice1.setSubtotal(new BigDecimal(19.99));
        inputInvoice1.setTax(new BigDecimal(0.06));
        inputInvoice1.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice1.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice1);

        Optional<Invoice> foundInvoice = invoiceRepo.findById(inputInvoice1.getInvoice_id());
        assertEquals(foundInvoice.get(), inputInvoice1);
    }

    // test getting all invoices
    @Test
    public void shouldGetAllInvoices() {
        Invoice inputInvoice1 = new Invoice();
        inputInvoice1.setName("John Doe");
        inputInvoice1.setStreet("123 Ocean Avenue");
        inputInvoice1.setCity("Los Angeles");
        inputInvoice1.setState("CA");
        inputInvoice1.setZipcode("08520");
        inputInvoice1.setItem_type("Shirt");
        inputInvoice1.setItem_id(2);
        inputInvoice1.setUnit_price(new BigDecimal(19.99));
        inputInvoice1.setQuantity(1);
        inputInvoice1.setSubtotal(new BigDecimal(19.99));
        inputInvoice1.setTax(new BigDecimal(0.06));
        inputInvoice1.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice1.setTotal(new BigDecimal(22.67));

        Invoice inputInvoice2 = new Invoice();
        inputInvoice2.setName("James Williams");
        inputInvoice2.setStreet("1323 Peachtree Avenue");
        inputInvoice2.setCity("Los Angeles");
        inputInvoice2.setState("CA");
        inputInvoice2.setZipcode("08520");
        inputInvoice2.setItem_type("Shirt");
        inputInvoice2.setItem_id(2);
        inputInvoice2.setUnit_price(new BigDecimal(19.99));
        inputInvoice2.setQuantity(1);
        inputInvoice2.setSubtotal(new BigDecimal(19.99));
        inputInvoice2.setTax(new BigDecimal(0.06));
        inputInvoice2.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice2.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice2);

        List<Invoice> invoiceList = invoiceRepo.findAll();
        //Assert...
        assertEquals(2, invoiceList.size());
    }

    // test getting all invoices by customer name
    @Test
    public void shouldFindInvoiceByName() {
        Invoice inputInvoice1 = new Invoice();
        inputInvoice1.setName("John Doe");
        inputInvoice1.setStreet("123 Ocean Avenue");
        inputInvoice1.setCity("Los Angeles");
        inputInvoice1.setState("CA");
        inputInvoice1.setZipcode("08520");
        inputInvoice1.setItem_type("Shirt");
        inputInvoice1.setItem_id(2);
        inputInvoice1.setUnit_price(new BigDecimal(19.99));
        inputInvoice1.setQuantity(1);
        inputInvoice1.setSubtotal(new BigDecimal(19.99));
        inputInvoice1.setTax(new BigDecimal(0.06));
        inputInvoice1.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice1.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice1);

        Invoice inputInvoice2 = new Invoice();
        inputInvoice2.setName("Amy Jenkins");
        inputInvoice2.setStreet("123 Ocean Avenue");
        inputInvoice2.setCity("Los Angeles");
        inputInvoice2.setState("CA");
        inputInvoice2.setZipcode("08520");
        inputInvoice2.setItem_type("Shirt");
        inputInvoice2.setItem_id(2);
        inputInvoice2.setUnit_price(new BigDecimal(19.99));
        inputInvoice2.setQuantity(1);
        inputInvoice2.setSubtotal(new BigDecimal(19.99));
        inputInvoice2.setTax(new BigDecimal(0.06));
        inputInvoice2.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice2.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice2);

        Invoice inputInvoice3 = new Invoice();
        inputInvoice3.setName("Emma Smith");
        inputInvoice3.setStreet("123 Ocean Avenue");
        inputInvoice3.setCity("Los Angeles");
        inputInvoice3.setState("CA");
        inputInvoice3.setZipcode("08520");
        inputInvoice3.setItem_type("Shirt");
        inputInvoice3.setItem_id(2);
        inputInvoice3.setUnit_price(new BigDecimal(19.99));
        inputInvoice3.setQuantity(1);
        inputInvoice3.setSubtotal(new BigDecimal(19.99));
        inputInvoice3.setTax(new BigDecimal(0.06));
        inputInvoice3.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice3.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice3);

        Invoice inputInvoice4 = new Invoice();
        inputInvoice4.setName("Sam Klien");
        inputInvoice4.setStreet("123 Ocean Avenue");
        inputInvoice4.setCity("Los Angeles");
        inputInvoice4.setState("CA");
        inputInvoice4.setZipcode("08520");
        inputInvoice4.setItem_type("Shirt");
        inputInvoice4.setItem_id(2);
        inputInvoice4.setUnit_price(new BigDecimal(19.99));
        inputInvoice4.setQuantity(1);
        inputInvoice4.setSubtotal(new BigDecimal(19.99));
        inputInvoice4.setTax(new BigDecimal(0.06));
        inputInvoice4.setProcessing_fee(new BigDecimal(1.49));
        inputInvoice4.setTotal(new BigDecimal(22.67));
        invoiceRepo.save(inputInvoice4);

        List<Invoice> invoiceList = invoiceRepo.findByName("Sam Klien");
        assertEquals(invoiceList.size(), 1);
    }
}