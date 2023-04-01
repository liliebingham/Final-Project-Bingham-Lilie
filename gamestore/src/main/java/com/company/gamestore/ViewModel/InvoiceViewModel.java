package com.company.gamestore.ViewModel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InvoiceViewModel {

    @NotNull
    private String name;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String zipcode;

    @NotNull
    private String item_type;

    @NotNull
    private int item_id;

    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal unit_price;

    @NotNull
    private BigDecimal subtotal;

    @NotNull
    private BigDecimal tax;

    @NotNull
    private BigDecimal processing_fee;

    @NotNull
    private BigDecimal total;


}
