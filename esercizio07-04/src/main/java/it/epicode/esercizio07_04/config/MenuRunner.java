package it.epicode.esercizio07_04.config;

import it.epicode.esercizio07_04.menu.Bevanda;
import it.epicode.esercizio07_04.menu.Pizza;
import it.epicode.esercizio07_04.menu.Topping;
import it.epicode.esercizio07_04.menu.BevandaRepository;
import it.epicode.esercizio07_04.menu.PizzaRepository;
import it.epicode.esercizio07_04.menu.ToppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MenuRunner implements CommandLineRunner {

    private final PizzaRepository pizzaRepository;
    private final ToppingRepository toppingRepository;
    private final BevandaRepository bevandaRepository;
    private final Pizza pizzaMargherita;
    private final Pizza pizzaProsciutto;
    private final Pizza pizzaSalame;
    private final Topping margheritaTopping;
    private final Topping prosciuttoTopping;
    private final Topping salameTopping;
    private final Bevanda acqua;
    private final Bevanda cola;
    private final Bevanda birra;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Menu Runner - Persisting Data...");

        // Salvataggio dei dati nel database
        pizzaRepository.saveAll(List.of(pizzaMargherita, pizzaProsciutto, pizzaSalame));
        toppingRepository.saveAll(List.of(margheritaTopping, prosciuttoTopping, salameTopping));
        bevandaRepository.saveAll(List.of(acqua, cola, birra));

        // Stampa dei dati dopo la persistenza
        System.out.println("-----------------");
        System.out.println("MENU");
        System.out.println("Pizze disponibili: " + pizzaRepository.findAll());
        System.out.println("Toppings disponibili: " + toppingRepository.findAll());
        System.out.println("Bevande disponibili: " + bevandaRepository.findAll());

        System.out.println("✅ Dati persisti correttamente!");
    }
}