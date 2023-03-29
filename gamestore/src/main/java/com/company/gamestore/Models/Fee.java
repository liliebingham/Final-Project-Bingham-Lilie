package com.company.gamestore.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="fee")
public class Fee {

    @Id
    private String product_type;

    @NotNull
    private BigDecimal fee;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee1 = (Fee) o;
        return Objects.equals(getProduct_type(), fee1.getProduct_type()) && Objects.equals(getFee(), fee1.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct_type(), getFee());
    }

    @Override
    public String toString() {
        return "Fee{" +
                "product_type='" + product_type + '\'' +
                ", fee=" + fee +
                '}';
    }
}

