package it.epicode.pizza_express_2.menu;

import it.epicode.pizza_express_2.ordini.Ordine;
import it.epicode.pizza_express_2.ordini.OrdineService;
import it.epicode.pizza_express_2.tavoli.Tavolo;
import it.epicode.pizza_express_2.tavoli.TavoloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MenuRunner implements CommandLineRunner {
    private final Menu menuPranzo;
    private final OrdineService ordineService;
    private final TavoloService tavoloService;
    private final List<RigaMenu> righeMenu;

    @Override
    public void run(String... args) throws Exception {
        menuPranzo.stampaMenu();
        stampaMenuStatico();
        stampaOrdine();
        stampaTavolo();
    }

    private void stampaMenuStatico() {
        System.out.println("-----------------");
        System.out.println("stampa statica");
        System.out.println("-----------------");
        printMenu(righeMenu);
    }

    private void stampaOrdine() {
        Ordine ordine = ordineService.creaOrdine();
        System.out.println("-----------------");
        System.out.println("Dettagli ordine");
        System.out.println("-----------------");
        System.out.println("Numero ordine: " + ordine.getNumeroOrdine());
        System.out.println("Stato ordine: " + ordine.getStatoOrdine());
        System.out.println("Numero coperti: " + ordine.getNumeroCoperti());
        System.out.println("Ora acquisizione: " + ordine.getOraAcquisizione());
        System.out.println("Importo totale: " + ordine.calcolaImportoTotale());
    }

    private void stampaTavolo() {
        Tavolo tavolo = tavoloService.creaTavolo(2, 1);
        System.out.println("-----------------");
        System.out.println("Dettagli tavolo");
        System.out.println("-----------------");
        System.out.println("Numero tavolo: " + tavolo.getNumeroTavolo());
        System.out.println("Numero coperti: " + tavolo.getNumeroCoperti());
        System.out.println("Stato tavolo: " + tavolo.getStato());
    }

    private void printMenu(List<RigaMenu> righe) {
        righe.forEach(riga -> System.out.println(riga.descrizioneRiga()));
    }
}