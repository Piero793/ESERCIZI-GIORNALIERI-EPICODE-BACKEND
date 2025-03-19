package it.epicode.main;

import it.epicode.classi.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static it.epicode.classi.istanze.istanze.listaOrdini;
import static it.epicode.classi.istanze.istanze.listaProdotti;

public class Main {
    public static void main(String[] args) {

        System.out.println("Elenco dei prodotti con prezzo superiore a 100:");
        listaProdotti.stream()
                .filter(p -> p.getPrice() > 100)
                .forEach(System.out::println);

        System.out.println("Elenco degli ordini dei prodotti di categoria baby");
        listaOrdini.stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("Baby")))
                .toList()
                .forEach(System.out::println);

        System.out.println("Elenco dei prodotti scontati:");

        List<Product> prodottiScontati = listaProdotti.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Boys"))
                .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9))
                .toList();
        prodottiScontati.forEach(System.out::println);

        // Lista di prodotti ordinati da clienti tier 2 tra il 1 febbraio 2021 e il 1 aprile 2021 (inclusi)
        System.out.println("Elenco dei prodotti ordinati da clienti tier 2 tra il 1 febbraio 21 e il 1 aprile 21:");

        List<Product> prodottiTier2 = listaOrdini.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) && o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
                .flatMap(o -> o.getProducts().stream())
                .toList();
        prodottiTier2.forEach(System.out::println);


    }

}
