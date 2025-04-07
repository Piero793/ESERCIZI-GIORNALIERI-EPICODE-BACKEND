package it.epicode.esercizio07_04.menu;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "beverages")
public class Bevanda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int calories;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    // Costruttore corretto per inizializzare i campi
    public Bevanda(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    // Costruttore vuoto per Hibernate
    public Bevanda() {
    }
}