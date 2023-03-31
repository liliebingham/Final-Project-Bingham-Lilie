package com.company.gamestore.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private int invoice_id;
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

    public int getInvoice_id() {
        return invoice_id;
    }
    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItem_type() {
        return item_type;
    }
    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }


    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoice_id() == invoice.getInvoice_id() && getItem_id() == invoice.getItem_id() && getQuantity() == invoice.getQuantity() && Objects.equals(getName(), invoice.getName()) && Objects.equals(getStreet(), invoice.getStreet()) && Objects.equals(getCity(), invoice.getCity()) && Objects.equals(getState(), invoice.getState()) && Objects.equals(getZipcode(), invoice.getZipcode()) && Objects.equals(getItem_type(), invoice.getItem_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoice_id(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItem_type(), getItem_id(), getQuantity());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoice_id=" + invoice_id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", item_type='" + item_type + '\'' +
                ", item_id=" + item_id +
                ", quantity=" + quantity +
                '}';
    }
}
