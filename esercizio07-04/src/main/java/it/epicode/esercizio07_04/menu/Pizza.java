package it.epicode.esercizio07_04.menu;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int calories;

    private List<Topping> toppings = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

}