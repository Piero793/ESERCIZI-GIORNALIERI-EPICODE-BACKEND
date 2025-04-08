package it.epicode.pizza_express_2.toppings;

import it.epicode.pizza_express_2.menu.RigaMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements RigaMenu {
    @Override
    public String descrizioneRiga() {
        return descrizione + " - " + prezzo + "€" + " - " + calorie + " kcal";
    }

    private String nome;
    private String descrizione;
    private double prezzo;
    private int calorie;

}
