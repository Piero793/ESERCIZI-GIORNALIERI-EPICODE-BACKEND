package it.epicode.esercizio07_04.menu;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "toppings")
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int calories;


    private Pizza pizza;

    // Costruttore corretto per inizializzare i campi
    public Topping(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    // Costruttore vuoto per Hibernate
    public Topping() {
    }
}