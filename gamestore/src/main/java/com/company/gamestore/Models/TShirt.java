package com.company.gamestore.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tshirt")
public class TShirt implements Serializable {
    @Id
    @Column(name = "tshirt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(max = 20)
    private String size;
    @NotNull
    @Size(max = 20)
    private String color;
    @NotNull
    @Size(max = 255)
    private String description;
    @NotNull
    @Digits(integer = 5, fraction = 2)
    private BigDecimal price;
    @NotNull
    private Integer quantity;

    public Integer getId(){ return id; }
    public void setId(Integer id) { this.id = id;}
    public String getSize() {return size;}
    public void setSize(String size) {this.size = size;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tshirt = (TShirt) o;
        return Objects.equals(getId(), tshirt.getId()) &&
                Objects.equals(getSize(), tshirt.getSize()) &&
                Objects.equals(getColor(), tshirt.getColor()) &&
                Objects.equals(getDescription(), tshirt.getDescription()) &&
                Objects.equals(getPrice(), tshirt.getPrice()) &&
                Objects.equals(getQuantity(), tshirt.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }
}
