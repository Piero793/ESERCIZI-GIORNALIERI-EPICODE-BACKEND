package it.epicode.pizza_express_2.menu;

import it.epicode.pizza_express_2.bevande.Bevanda;
import it.epicode.pizza_express_2.pizze.Pizza;
import it.epicode.pizza_express_2.toppings.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String nome;
    private String descrizione;

    private List<Pizza> pizze = new ArrayList<>();
    private List<Bevanda> bevande = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();

    public void stampaMenu() {
        System.out.println("-- Menu " + nome + " --");
        System.out.println("--- pizze ---");
        for (Pizza pizza : pizze) {
            System.out.println(pizza.descrizioneRiga());
        }

        System.out.println("--- bevande ---");
        for (Bevanda bevanda : bevande) {
            System.out.println(bevanda.descrizioneRiga());
        }

        System.out.println("--- toppings ---");
        for (Topping topping : toppings) {
            System.out.println(topping.descrizioneRiga());
        }

    }

}
