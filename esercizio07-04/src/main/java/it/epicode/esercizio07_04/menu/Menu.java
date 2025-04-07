package it.epicode.esercizio07_04.menu;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Pizza> pizzas;


    private List<Topping> toppings;

    @OneToMany(mappedBy = "menu")
    private List<Bevanda> beverages;
}