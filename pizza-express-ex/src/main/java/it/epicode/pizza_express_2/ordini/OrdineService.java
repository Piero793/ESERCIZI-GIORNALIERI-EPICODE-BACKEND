package it.epicode.pizza_express_2.ordini;

import it.epicode.pizza_express_2.menu.Menu;
import it.epicode.pizza_express_2.tavoli.Tavolo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;


@Service
public class OrdineService {

    private final Menu menuPranzo;
    private final int costoCoperto;

    public OrdineService(Menu menuPranzo, @Value("${pizza.coperto}") int costoCoperto) {
        this.menuPranzo = menuPranzo;
        this.costoCoperto = costoCoperto;
    }

    public Ordine creaOrdine() {
        return new Ordine(new Tavolo(), menuPranzo, 1, StatoOrdine.IN_CORSO, 1, "12:00", costoCoperto);
    }
}