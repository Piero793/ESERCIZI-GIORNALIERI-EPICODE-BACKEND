package it.epicode.pizza_express_2.ordini;

import it.epicode.pizza_express_2.menu.Menu;
import it.epicode.pizza_express_2.tavoli.Tavolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordine {
    private Tavolo tavolo;
    private Menu menu;
    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private String oraAcquisizione;
    private int costoCoperto;



    //metodo per calcolare l'importo totale
    // dato dalla somma del prezzo degli elementi del menu ed  il numero di coperti
    public double calcolaImportoTotale() {
        double importoTotale = menu.getPizze().stream().mapToDouble(pizza -> pizza.getPrezzo()).sum();
        importoTotale += menu.getBevande().stream().mapToDouble(bevanda -> bevanda.getPrezzo()).sum();
        importoTotale += menu.getToppings().stream().mapToDouble(topping -> topping.getPrezzo()).sum();
        importoTotale += numeroCoperti * costoCoperto; // Aggiunge il costo del coperto
        return importoTotale;
    }



}
