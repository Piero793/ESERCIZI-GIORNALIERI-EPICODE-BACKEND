package it.epicode.pizza_express_2.ordini;

import it.epicode.pizza_express_2.bevande.Bevanda;
import it.epicode.pizza_express_2.menu.Menu;
import it.epicode.pizza_express_2.pizze.Pizza;
import it.epicode.pizza_express_2.tavoli.Tavolo;
import it.epicode.pizza_express_2.toppings.Topping;
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
        double importoTotale = menu.getPizze().stream().mapToDouble(Pizza::getPrezzo).sum();
        importoTotale += menu.getBevande().stream().mapToDouble(Bevanda::getPrezzo).sum();
        importoTotale += menu.getToppings().stream().mapToDouble(Topping::getPrezzo).sum();
        importoTotale += numeroCoperti * costoCoperto;
        return importoTotale;
    }



}
