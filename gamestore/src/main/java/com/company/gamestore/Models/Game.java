package com.company.gamestore.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="game")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_id")
    private int game_id;
    @NotNull
    private String title;
    @NotNull
    @Column(name="esrb_rating")
    private String esrbRating;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String studio;
    private int quantity;

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(getGame_id(), game.getGame_id()) && Objects.equals(getTitle(), game.getTitle()) && Objects.equals(getEsrbRating(), game.getEsrbRating()) && Objects.equals(getDescription(), game.getDescription()) && Objects.equals(getPrice(), game.getPrice()) && Objects.equals(getStudio(), game.getStudio()) && Objects.equals(getQuantity(), game.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame_id(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }
}
