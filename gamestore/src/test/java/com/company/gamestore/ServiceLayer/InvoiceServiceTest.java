package com.company.gamestore.ServiceLayer;

import com.company.gamestore.Controllers.ConsoleController;
import com.company.gamestore.Models.*;
import com.company.gamestore.Repositories.*;
import com.company.gamestore.ViewModel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class InvoiceServiceTest {

    TaxRepository taxRepo;
    FeeRepository feeRepo;
    GameRepository gameRepo;
    TShirtRepository tshirtRepo;
    ConsoleRepository consoleRepo;
    InvoiceRepository invoiceRepo;

    InvoiceService service;

    @Before
    public void setUp() throws Exception {
        setUpTaxRepositoryMock();
        setUpFeeRepositoryMock();
        setUpGameRepositoryMock();
        setUpTShirtRepositoryMock();
        setUpConsoleRepositoryMock();
        setUpTShirtRepositoryMock();
        setUpInvoiceMock();

        service = new InvoiceService(taxRepo, feeRepo, gameRepo, tshirtRepo, consoleRepo, invoiceRepo);

    }

    private void setUpConsoleRepositoryMock() {
        consoleRepo = mock(ConsoleRepository.class);
        Console console = new Console();
        console.setModel("Nintendo Switch");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("50GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(2);
        console.setConsole_id(1);

        Console console2 = new Console();
        console.setModel("Nintendo Switch Lite");
        console.setManufacturer("Nintendo");
        console.setMemory_amount("25GB");
        console.setProcessor("Nvidia Tegra X1");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(1);

        List aList = new ArrayList();
        aList.add(console);

        doReturn(console).when(consoleRepo).save(console2);
        doReturn(Optional.of(console)).when(consoleRepo).findById(1);
        doReturn(aList).when(consoleRepo).findAll();
    }

    private void setUpTShirtRepositoryMock() {
        tshirtRepo = mock(TShirtRepository.class);
        TShirt inputTShirt = new TShirt();
        inputTShirt.setSize("S");
        inputTShirt.setColor("Red");
        inputTShirt.setDescription("The Office T-Shirt -features a graphic of The Office's logo and characters. It is made from soft, comfortable cotton");
        inputTShirt.setPrice(new BigDecimal("15.99"));
        inputTShirt.setQuantity(20);
        inputTShirt.setId(1);

        TShirt tShirt2 = new TShirt();
        inputTShirt.setSize("L");
        inputTShirt.setColor("Blue");
        inputTShirt.setDescription("The Office T-Shirt -features a graphic of The Office's logo and characters. It is made from soft, comfortable cotton");
        inputTShirt.setPrice(new BigDecimal("15.99"));
        inputTShirt.setQuantity(10);

        List aList = new ArrayList();
        aList.add(inputTShirt);

        doReturn(inputTShirt).when(tshirtRepo).save(tShirt2);
        doReturn(Optional.of(inputTShirt)).when(tshirtRepo).findById(1);
        doReturn(aList).when(tshirtRepo).findAll();
    }

    private void setUpGameRepositoryMock() {

        gameRepo = mock(GameRepository.class);
        Game game = new Game();
        game.setTitle("Minecraft");
        game.setEsrbRating("E");
        game.setDescription("A game where you mine and craft!");
        game.setPrice(new BigDecimal("20.00"));
        game.setStudio("Microsoft");
        game.setQuantity(100);
        game.setGame_id(1);

        Game game2 = new Game();
        game2.setTitle("Stardew Valley");
        game2.setEsrbRating("E");
        game2.setDescription("A game where you mine and farm!");
        game2.setPrice(new BigDecimal("14.99"));
        game2.setStudio("ConcernedApe");
        game2.setQuantity(50);

        List aList = new ArrayList();
        aList.add(game);

        doReturn(game).when(gameRepo).save(game2);
        doReturn(Optional.of(game)).when(gameRepo).findById(1);
        doReturn(aList).when(gameRepo).findAll();


    }

    private void setUpInvoiceMock() {

        invoiceRepo = mock(InvoiceRepository.class);
        //doReturn(game).when(gameRepo).save(game2);

    }

    private void setUpFeeRepositoryMock() {

        feeRepo = mock(FeeRepository.class);
        Fee fee = new Fee();
        fee.setFee(new BigDecimal("5.99"));
        fee.setProductType("TShirt");
        doReturn(Optional.of(fee)).when(feeRepo).findByProductType("TShirt");


    }

    private void setUpTaxRepositoryMock() {

        taxRepo = mock(TaxRepository.class);
        Tax tax = new Tax();
        tax.setRate(new BigDecimal("10.99"));
        tax.setState("CA");
        doReturn(Optional.of(tax)).when(taxRepo).findByState("CA");
    }

    @Test
    public void shouldSaveInvoice() {


        // Arrange
        Invoice expectedResult = new Invoice();
        expectedResult.setName("John Doe");
        expectedResult.setStreet("123 Ocean Avenue");
        expectedResult.setCity("Los Angeles");
        expectedResult.setState("CA");
        expectedResult.setZipcode("08520");
        expectedResult.setItem_type("Shirt");
        expectedResult.setItem_id(2);
        expectedResult.setQuantity(1);

        /*expectedResult.setProcessing_fee();
        expectedResult.setSubtotal();
        expectedResult.setUnit_price();
        expectedResult.setTotal();*/

        InvoiceViewModel testViewModel = new InvoiceViewModel();
        testViewModel.setName("John Doe");
        testViewModel.setStreet("123 Ocean Avenue");
        testViewModel.setCity("Los Angeles");
        testViewModel.setState("CA");
        testViewModel.setZipcode("08520");
        testViewModel.setItem_type("Shirt");

        testViewModel.setItem_id(2);
        testViewModel.setQuantity(1);

        // ACT
        Invoice testInvoice = service.saveInvoice(testViewModel);

        assertEquals(expectedResult, testInvoice);
        //test to check if the subtotal, fee, tax and total are correct
    }





    @Test
    public void shouldUpdateInventoryQuantity() {

    }

}